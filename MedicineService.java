package com.io.codesystem.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.io.codesystem.dto.model.Medicine;
import com.io.codesystem.repo.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicinerepository;
	
	@Autowired
	private EntityManager entityManager;
	
	public void createMedicineIndex() throws Exception {

		SearchSession searchSession = Search.session(entityManager);
		MassIndexer massIndexer = searchSession.massIndexer(Medicine.class);
		massIndexer.type(Medicine.class);
		//massIndexer.type(Medicine.class).reindexOnly("e.versionState='Valid'");
		//reindexOnly("e.type='v'");

		massIndexer.idFetchSize(250).batchSizeToLoadObjects(200).threadsToLoadObjects(4).startAndWait();
	}

	public Page<Medicine> searchMedicine(String searchTerm, Pageable pageable) {
		// TODO Auto-generated method stub
		int pageNumber = pageable.getPageNumber();
		int pageSize = pageable.getPageSize();
		int maxEditDistance=2;
		int minPrefixLength = 3;

		SearchSession searchSession = Search.session(entityManager);
				SearchResult<Medicine> result = searchSession.search(Medicine.class)
						.where(f -> f.bool()
						        .should(f.match()
						            .field("ndc")
						            .matching(searchTerm)
						            
						        )
						        .should(f.match()
						            .field("name")
						            .matching(searchTerm)
						            .fuzzy(maxEditDistance,minPrefixLength) // To cover spelling corrections
						           
						        )
						    ).fetch(Integer.MAX_VALUE);

		long totalHitCount = result.total().hitCount();
		List<Medicine> allHits = result.hits();
		System.out.println("Total Hits Count:" + totalHitCount);
		System.out.println(" Hits Count:" + allHits.size());
		int fromIndex = pageNumber * pageSize;
	    int toIndex = Math.min(fromIndex + pageSize, allHits.size());
		List<Medicine> hits = allHits.subList(fromIndex,toIndex);

				    return new PageImpl<>(hits, pageable, totalHitCount);
	}

}

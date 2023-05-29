package com.io.codesystem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.massindexing.MassIndexer;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.io.codesystem.dto.model.Allergy;
import com.io.codesystem.repo.AllergyRepository;

@Service
public class AllergyService {

	@Autowired
	AllergyRepository allergyRepository;

	@Autowired
	private  EntityManager entityManager;

	public void createAllergyIndex() throws Exception {

		SearchSession searchSession = Search.session(entityManager);
		MassIndexer massIndexer = searchSession.massIndexer();
		massIndexer.type(Allergy.class);
		// .reindexOnly("e.type='v'");

		massIndexer.idFetchSize(250).batchSizeToLoadObjects(200).threadsToLoadObjects(4).startAndWait();
	}

	public Page<Allergy> searchAllergyCode(String searchTerm, Pageable pageable) {

		int maxEditDistance=2;
		int minPrefixLength = 3;
		  int pageNumber = pageable.getPageNumber();
		    int pageSize = pageable.getPageSize();
		
		SearchSession searchSession = Search.session(entityManager);
		SearchResult<Allergy> result = searchSession.search(Allergy.class)
				
				
				.where(f -> f.bool()
						 .should(f.match()
						            .fields("damConceptIdDesc", "damAlrgnGrpDesc","allergyDesc")
						            .matching(searchTerm)
						            .fuzzy(maxEditDistance,minPrefixLength))) // To cover spelling corrections
						  //  .fetch(pageable.getPageSize());
		                    .fetch(Integer.MAX_VALUE);
				
			
		        
//		            .should(f.match()
//		                .fields("shortName")
//		                .matching(searchTerm)
//		                .fuzzy(maxEditDistance, minPrefixLength)))
//		        .fetch(Integer.MAX_VALUE);
		                    
		   
				
//				.where(f -> f.bool()
//						.should(f.wildcard().field("damConceptIdDesc").matching(searchTerm + "*"))
//						.should(f.wildcard().field("damAlrgnGrpDesc").matching(searchTerm + "*"))
//					.should(f.wildcard().field("allergyDesc").matching(searchTerm + "*"))
//					.should(f.simpleQueryString().fields("damConceptIdDesc", "damAlrgnGrpDesc", "allergyDesc")
//				    .matching(searchTerm)))
//			        .fetch(pageable.getPageSize());

		
		//.f.where(f -> f.wildcard().fields("damConceptIdDesc", "damAlrgnGrpDesc","allergyDesc").matching(searchTerm)).fetch(pageable.getPageSize());
		

		long totalHitCount = result.total().hitCount();
		List<Allergy> allHits = result.hits();
		int fromIndex = pageNumber * pageSize;
	    int toIndex = Math.min(fromIndex + pageSize, allHits.size());
	    List<Allergy> hits = allHits.subList(fromIndex, toIndex);
		System.out.println("Total Hits Count:" + totalHitCount);
		System.out.println(" Hits Count:" + result.hits().size());
		return new PageImpl<>(hits, pageable, totalHitCount);
	   

	}

}

package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Cpt;

import com.example.demo.Repository.CptRepository;



@Service
public class CptService {

	@Autowired
	CptRepository cptRepository;
	

	public Cpt createCpt(Cpt cptReq) {
		// TODO Auto-generated method stub
		
		return cptRepository.save(cptReq);
	}

	public List<Cpt> getCpt() {
		// TODO Auto-generated method stub
		return cptRepository.findAll();
	}

	public Cpt getCptById(int id) {
		// TODO Auto-generated method stub
		return cptRepository.findById(id).get();
	}

	public Cpt updateCpt(int id, Cpt cptReq) {
		// TODO Auto-generated method stub
		Optional<Cpt> existingCode = cptRepository.findById(cptReq.getId());
		existingCode.ifPresent(existingcode -> {
			// Updating Existing Code
			existingcode.setVersionState("InValid");
			existingcode.setRetired("Y");
			// existingCptCode.setRetired("Y");
			cptRepository.save(existingcode);
			// Inserting Modified Code As New One
			cptReq.setRefId(existingcode.getId());
			cptReq.setOriginalRefId(existingcode.getOriginalRefId());
			cptReq.setRetired("N");
			cptReq.setId(0);
			cptRepository.save(cptReq);
		});
		return cptReq;
	}

	public void deleteCptById(int id) {
		// TODO Auto-generated method stub
		cptRepository.deleteById(id);
	}

	public Page<Cpt> getCptBycodeOrShortName(String codeOrShortName, Integer pageSize, Integer pageNumber,String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy.equals("Newest First") ? Sort.Direction.DESC : Sort.Direction.ASC, "id"));
		 if (codeOrShortName.length() >= 3) {
	            // Search for exact matches of code or short name
	            return cptRepository.findByCodeOrShortName(codeOrShortName, pageable);
	        } else {
	            // Search for related codes based on code or short name using wildcard search
	            String searchQuery = "*" + codeOrShortName.toLowerCase() + "*";
	            return cptRepository.findByCodeOrShortNameLike(searchQuery, pageable);
	        }
	    }
	
	






	
	}

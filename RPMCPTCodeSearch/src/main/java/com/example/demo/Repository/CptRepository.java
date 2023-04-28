package com.example.demo.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cpt;

@Repository
public interface CptRepository extends JpaRepository<Cpt,Integer> {

	@Query("select t from Cpt t where t.shortName like %:codeOrShortName% or t.code like %:codeOrShortName%")
	Page<Cpt> findByCodeOrShortName(String codeOrShortName, Pageable pageable);
    
	@Query("select t from Cpt t where t.shortName like %:searchQuery% or t.code like %:searchQuery%")
	Page<Cpt> findByCodeOrShortNameLike(String searchQuery, Pageable pageable);
	
	
	
	

	
	
   
	
}

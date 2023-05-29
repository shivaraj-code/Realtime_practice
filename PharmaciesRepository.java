package com.io.codesystem.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.io.codesystem.dto.model.Pharmacies;

@Repository
public interface PharmaciesRepository extends JpaRepository<Pharmacies, Integer>{

	
	
}

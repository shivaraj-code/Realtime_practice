package com.io.codesystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.io.codesystem.dto.model.CptCodeCategory;

@Repository
public interface CptCodeCategorySearchRepository extends JpaRepository<CptCodeCategory, Long> {

	@Query(value = "CALL getCptCodeCategorySearch(:codeorshort)", nativeQuery = true)
	public List<CptCodeCategory> getCptCodeByCodeOrShortWithCtg(String codeorshort);

}

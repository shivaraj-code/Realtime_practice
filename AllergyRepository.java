package com.io.codesystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.io.codesystem.dto.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Integer> {

	// @Query(value = "select * from allergy_new where
	// match(dam_alrgn_grp_desc,dam_concept_id_desc,allergy_desc)
	// against(:searchString) AND version_state='Validated'", nativeQuery = true)
	// @Query(value="select * from allergy_new where dam_concept_id_desc like
	// %:damConceptIdDescOrdamAlrgnGrpDescOrallergyDesc% or dam_alrgn_grp_desc like
	// %:damConceptIdDescOrdamAlrgnGrpDescOrallergyDesc% or allergy_desc like
	// %:damConceptIdDescOrdamAlrgnGrpDescOrallergyDesc% " ,nativeQuery=true)
	// Page<Allergy> getallergySearchResult(String searchString, Pageable pageable);
}

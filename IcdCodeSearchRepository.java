package com.io.codesystem.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.io.codesystem.dto.model.IcdCodeTree;

public interface IcdCodeSearchRepository extends JpaRepository<IcdCodeTree, Integer>{

//	@Query(value="CALL get_Icd_tree(:icd10id)",nativeQuery=true)
//	public List<IcdCodeTree> get_Icd_tree(Integer icd10id);
	
	@Query(value="CALL get_Icd_tree(:icd10id)",nativeQuery=true)
	public List<IcdCodeTree> get_Icd_tree(Integer icd10id);

		}


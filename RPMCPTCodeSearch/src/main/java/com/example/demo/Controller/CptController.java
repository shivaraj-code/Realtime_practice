package com.example.demo.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Cpt;
import com.example.demo.Service.CptService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@RestController
//@RequestMapping("/cpt")
public class CptController {
	
	@Autowired
	CptService cptService;
	
	@PostMapping("/cpt/add")
	public ResponseEntity<String> createCpt(@RequestBody Cpt cptReq) {
		Cpt cpt = cptService.createCpt(cptReq);
		return ResponseEntity.status(201).body("CPT Id is created" + cpt.getId());
	}

	@GetMapping("/cpt/list")
	public List<Cpt> getCpt() {
		return cptService.getCpt();

	}

	@GetMapping("/cpt/list/{id}")
	public Cpt getCptById(@PathVariable int id) {
		return cptService.getCptById(id);
	}

	@PutMapping("/cpt/edit/{id}")
	public ResponseEntity<String> updateCpt(@PathVariable int id, @RequestBody Cpt cptReq) {
		Cpt cpt = cptService.updateCpt(id, cptReq);
		return ResponseEntity.status(201).body("CPT Id is updated" + cpt.getId());

	}

	@DeleteMapping("/cpt/delete/{id}")
	public ResponseEntity<String> deleteCptById(@PathVariable int id) {
		cptService.deleteCptById(id);
		return ResponseEntity.status(201).body("CPT Id is deleted");
	}
	
	@GetMapping("/paginationsearchsorting")
	public Page<Cpt> getCptBycodeOrShortName(@RequestParam (value ="searchstring" ) String codeOrShortName,@RequestParam(defaultValue = "10")
	Integer pageSize,@RequestParam(defaultValue = "0")  Integer pageNumber,@RequestParam(value = "sortBy", required = false, defaultValue = "Newest First")  
	String sortBy ){
		
		return cptService.getCptBycodeOrShortName(codeOrShortName,pageSize,pageNumber,sortBy);
	}


	

}

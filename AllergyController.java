package com.io.codesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.io.codesystem.dto.model.Allergy;
import com.io.codesystem.service.AllergyService;


@RestController
public class AllergyController {

	@Autowired
	AllergyService allergyService;

	@GetMapping("/allergy/search")
	public ResponseEntity<Page<Allergy>> searchAllergyCode(@RequestParam String searchTerm, Pageable pageable) {
		Page<Allergy> searchResults = null;

		try {
			searchResults = allergyService.searchAllergyCode(searchTerm, pageable);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return new ResponseEntity<>(searchResults, new HttpHeaders(), HttpStatus.OK);

	}

	@PostMapping("/allergy/index")
	public ResponseEntity<String> createAllergyIndex() {

		String response = "Allergy Index created successfully";

		try {
			allergyService.createAllergyIndex();
		} catch (Exception e) {

			response = "Failed to create Allergy Index";
			
			e.printStackTrace();
			return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
	}
}

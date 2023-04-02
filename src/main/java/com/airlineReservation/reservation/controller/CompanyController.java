package com.airlineReservation.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlineReservation.reservation.entities.Company;
import com.airlineReservation.reservation.requests.CompanyRequest;
import com.airlineReservation.reservation.services.CompanyService;

@RestController
@CrossOrigin
public class CompanyController {
	
	@Autowired
	private CompanyService service;

	@GetMapping("/company")
	public ResponseEntity<Company> getCompany(@RequestParam(name = "id") int id) {
		
		return new ResponseEntity<Company>(this.service.company(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/companies")
	public ResponseEntity<List<Company>> getCompanies() {
		return new ResponseEntity<List<Company>>(this.service.companies(),HttpStatus.OK);
	}
	
	@PostMapping("/company")
	public ResponseEntity<Company> createCompany(@RequestBody Company c ) {
		return new ResponseEntity<Company>(this.service.create(c),HttpStatus.CREATED);
	}
	
	@PutMapping("/company")
	public ResponseEntity<Company> updateCompany(@RequestParam(name = "id") int id ,@RequestBody CompanyRequest r) {
		this.service.update(id, r);
		return new ResponseEntity<Company>(HttpStatus.OK);
	}
	
	@DeleteMapping("/company")
	public ResponseEntity<Company> deleteCompany(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<Company>(HttpStatus.OK);
	}

}

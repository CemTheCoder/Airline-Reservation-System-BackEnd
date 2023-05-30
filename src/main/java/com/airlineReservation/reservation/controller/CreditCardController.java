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
import com.airlineReservation.reservation.entities.CreditCard;
import com.airlineReservation.reservation.requests.CompanyRequest;
import com.airlineReservation.reservation.requests.CreditCardRequest;
import com.airlineReservation.reservation.services.CreditCardService;

@RestController
@CrossOrigin
public class CreditCardController {
	
	@Autowired
	private CreditCardService service;
	
	@GetMapping("/credit")
	public ResponseEntity<CreditCard> getCreditCard(@RequestParam(name = "id") int id) {
		
		return new ResponseEntity<CreditCard>(this.service.creditCard(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/credits")
	public ResponseEntity<List<CreditCard>> getCreditCards() {
		return new ResponseEntity<List<CreditCard>>(this.service.creditCards(),HttpStatus.OK);
	}
	
	@PostMapping("/credit")
	public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCardRequest r ) {
		return new ResponseEntity<CreditCard>(this.service.create(r),HttpStatus.CREATED);
	}
	
	@PutMapping("/credit")
	public ResponseEntity<CreditCard> updateCreditCard(@RequestParam(name = "id") int id ,@RequestBody CreditCardRequest r) {
		this.service.update(id, r);
		return new ResponseEntity<CreditCard>(HttpStatus.OK);
	}
	
	@DeleteMapping("/credit")
	public ResponseEntity<CreditCard> deleteCreditCard(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<CreditCard>(HttpStatus.OK);
	}

}

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

import com.airlineReservation.reservation.entities.City;

import com.airlineReservation.reservation.requests.CityRequest;

import com.airlineReservation.reservation.services.CityService;

@RestController
@CrossOrigin
public class CityController {
	
	@Autowired
	private CityService service;
	

	@GetMapping("/cities")
	private ResponseEntity<List<City>> getCities() {
		return new ResponseEntity<List<City>>(this.service.cities() , HttpStatus.OK);
	}
	
	@GetMapping("/city")
	private ResponseEntity<City> getCity(@RequestParam(name = "id") int id) {
		return new ResponseEntity<City>(this.service.city(id) , HttpStatus.OK);
	}
	
	@PostMapping("/city")
	private ResponseEntity<City> createCity(@RequestBody City c) {
		return new ResponseEntity<City>(this.service.create(c) , HttpStatus.CREATED);
	}
	
	@PutMapping("/city")
	private ResponseEntity<City> updateCity(@RequestParam(name = "id") int id , @RequestBody CityRequest c) {
		this.service.update(id, c);
		return new ResponseEntity<City>(HttpStatus.OK);
	}
	
	@DeleteMapping("/city")
	private ResponseEntity<City> deleteCity(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<City>(HttpStatus.OK);
	}

}

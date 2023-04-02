package com.airlineReservation.reservation.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.airlineReservation.reservation.dao.AirPlaneDao;
import com.airlineReservation.reservation.entities.AirPlane;
import com.airlineReservation.reservation.requests.AirPlaneRequest;
import com.airlineReservation.reservation.services.AirPlaneService;

@RestController
@CrossOrigin
public class AirPlaneController {
	
	
	@Autowired
	private AirPlaneService service;
	
	@GetMapping("/airplanes")
	public ResponseEntity<List<AirPlane>> getAirplanes() {
		return new ResponseEntity<List<AirPlane>>(this.service.airPlanes() , HttpStatus.OK);
	}
	
	@GetMapping("/airplane")
	public ResponseEntity<AirPlane> getAirplane(@RequestParam(name = "id") int id) {
		return new ResponseEntity<AirPlane>(this.service.airplane(id) , HttpStatus.OK);
	}
	
	@PostMapping("/airplane")
	public ResponseEntity<AirPlane> createAirplane(@RequestBody AirPlane a) {
		return new ResponseEntity<AirPlane>(this.service.create(a) , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/airplane")
	public ResponseEntity<AirPlane> deleteAirplane(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<AirPlane>(HttpStatus.OK);
	}
	
	@PutMapping("/airplane")
	public ResponseEntity<AirPlane> updateAirPlane(@RequestParam(name = "id") int id , @RequestBody AirPlaneRequest r ) {
		
		return new ResponseEntity<AirPlane>(this.service.update(id,r),HttpStatus.OK);
	}
	
	

	

}

package com.airlineReservation.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlineReservation.reservation.dao.PilotDao;
import com.airlineReservation.reservation.entities.Pilot;
import com.airlineReservation.reservation.requests.PilotRequest;
import com.airlineReservation.reservation.services.PilotService;

@RestController
public class PilotController {

	@Autowired
	private PilotService service;
	
	@GetMapping("/pilots")
	private ResponseEntity<List<Pilot>> getPilots() {
		return new ResponseEntity<List<Pilot>>(this.service.pilots() , HttpStatus.OK);
	}
	
	@GetMapping("/pilot")
	private ResponseEntity<Pilot> getPilot(@RequestParam(name = "id") int id) {
		return new ResponseEntity<Pilot>(this.service.pilot(id) , HttpStatus.OK);
	}
	
	@PostMapping("/pilot")
	private ResponseEntity<Pilot> createPilot(@RequestBody Pilot p) {
		return new ResponseEntity<Pilot>(this.service.create(p) , HttpStatus.CREATED);
	}
	
	@PutMapping("/pilot")
	private ResponseEntity<Pilot> updatePilot(@RequestParam(name = "id") int id , @RequestBody PilotRequest r) {
		this.service.update(id, r);
		return new ResponseEntity<Pilot>(HttpStatus.OK);
	}
	
	@DeleteMapping("/pilot")
	private ResponseEntity<Pilot> deletePilot(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<Pilot>(HttpStatus.OK);
	}
	

}

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

import com.airlineReservation.reservation.entities.AirPlane;
import com.airlineReservation.reservation.entities.Trip;
import com.airlineReservation.reservation.requests.TripRequest;
import com.airlineReservation.reservation.services.TripService;

@RestController
@CrossOrigin
public class TripController {

	@Autowired
	private TripService service;
	
	@GetMapping("/trips")
	public ResponseEntity<List<Trip>> getTrips() {
		return new ResponseEntity<List<Trip>>(this.service.trips() , HttpStatus.OK);
	}
	
	@GetMapping("/trip")
	public ResponseEntity<Trip> getTrip(@RequestParam(name = "id") int id) {
		return new ResponseEntity<Trip>(this.service.trip(id) , HttpStatus.OK);
	}
	
	@PostMapping("/trip")
	public ResponseEntity<Trip> createTrip(
			@RequestParam(name = "takeoff") String takeOff,
			@RequestParam(name = "destination") String destination,
			@RequestParam(name = "takeOffTime") String takeOffTime,
			@RequestParam(name = "returnTime") String returnTime,
			@RequestParam(name = "price") double price
			) {
		return new ResponseEntity<Trip>(this.service.create(takeOff,destination,takeOffTime,returnTime,price) , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/trip")
	public ResponseEntity<Trip> deleteTrip(@RequestParam(name = "id") int id) {
		
		this.service.delete(id);
		return new ResponseEntity<Trip>(HttpStatus.OK);
	}
	
	@PutMapping("/trip")
	public ResponseEntity<Trip> updateTrip(@RequestParam(name = "id") int id , @RequestBody TripRequest r) {
		
		return new ResponseEntity<Trip>(this.service.update(id,r), HttpStatus.OK);
	}
	
	@GetMapping("/tripsby")
	public ResponseEntity<List<Trip>> searchTrip(
			@RequestParam(name = "takeOffPoint") String takeOffPoint ,
			@RequestParam(name = "destination") String destination,
			@RequestParam(name = "takeOffTime") String takeOffTime,
			@RequestParam(name = "returnTime" ,  required = false , defaultValue = "null") String returnTime ,
			@RequestParam(name = "type") int type
			) {
		
		return new ResponseEntity<List<Trip>>(this.service.tripsBy(takeOffPoint, destination, takeOffTime , returnTime , type ),HttpStatus.OK);
	}

}

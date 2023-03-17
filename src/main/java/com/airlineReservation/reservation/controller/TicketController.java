package com.airlineReservation.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airlineReservation.reservation.entities.Pilot;
import com.airlineReservation.reservation.entities.Ticket;
import com.airlineReservation.reservation.requests.PilotRequest;
import com.airlineReservation.reservation.requests.TicketRequest;
import com.airlineReservation.reservation.services.PilotService;
import com.airlineReservation.reservation.services.TicketService;

@RestController
public class TicketController {

	
	@Autowired
	private TicketService service;
	
	@GetMapping("/tickets")
	private ResponseEntity<List<Ticket>> getTickets() {
		return new ResponseEntity<List<Ticket>>(this.service.tickets() , HttpStatus.OK);
	}
	
	@GetMapping("/ticket")
	private ResponseEntity<Ticket> getTicket(@RequestParam(name = "id") int id) {
		return new ResponseEntity<Ticket>(this.service.ticket(id) , HttpStatus.OK);
	}
	
	@PostMapping("/ticket")
	private ResponseEntity<Ticket> createTicket(@RequestBody Ticket t) {
		return new ResponseEntity<Ticket>(this.service.create(t) , HttpStatus.CREATED);
	}
	
	@PutMapping("/ticket")
	private ResponseEntity<Ticket> updateTicket(@RequestParam(name = "id") int id , @RequestBody TicketRequest r) {
		this.service.update(id, r);
		return new ResponseEntity<Ticket>(HttpStatus.OK);
	}
	
	@DeleteMapping("/ticket")
	private ResponseEntity<Ticket> deleteTicket(@RequestParam(name = "id") int id) {
		this.service.delete(id);
		return new ResponseEntity<Ticket>(HttpStatus.OK);
	}
	
	

}

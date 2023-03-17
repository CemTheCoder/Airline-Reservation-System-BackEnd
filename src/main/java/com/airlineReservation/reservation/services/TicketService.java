package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.TicketDao;
import com.airlineReservation.reservation.entities.Company;
import com.airlineReservation.reservation.entities.Ticket;
import com.airlineReservation.reservation.requests.CompanyRequest;
import com.airlineReservation.reservation.requests.TicketRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao dao;
	

	public Ticket ticket(int id) {
		return this.dao.findById(id);
	}
	
	public List<Ticket> tickets() {
		return this.dao.findAll();
	}
	
	public Ticket create(Ticket t) {
		return this.dao.save(t);
	}
	
	public Ticket update(int id,TicketRequest r) {
		Ticket t = this.dao.findById(id);
		if(r.getPrice()!=t.getPrice()) {
			t.setPrice(r.getPrice());
		} 
		if(r.getUser()!=null) {
			t.setUser(r.getUser());
		}
		if(r.getTrip()!=null) {
			t.setTrip(r.getTrip());
		}
		return this.dao.save(t);
	}
	
	public void delete(int id) {
		Ticket t = this.dao.findById(id);
		this.dao.delete(t);
	}
	
	


	
}

package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.PilotDao;
import com.airlineReservation.reservation.entities.Pilot;
import com.airlineReservation.reservation.entities.User;
import com.airlineReservation.reservation.requests.PilotRequest;

@Service
public class PilotService {
	
	@Autowired
	private PilotDao dao;
	
	public Pilot pilot(int id) {
		return this.dao.findById(id);
	}
	
	public List<Pilot> pilots() {
		return this.dao.findAll();
	}
	
	public Pilot create(Pilot p) {
		return this.dao.save(p);
	}
	
	public Pilot update(int id , PilotRequest r) {
		Pilot pilot = this.dao.findById(id);
		if(r.getAirPlanes() != null) {
		pilot.setAirPlanes(r.getAirPlanes());
		}
		if(r.getName() != null) {
		pilot.setName(r.getName());
		}
		if(r.getSurname() != null) {
		pilot.setSurname(r.getSurname());
		}
		return this.dao.save(pilot);
	}
	
	public void delete(int id) {
		Pilot pilot = this.dao.findById(id);
		this.dao.delete(pilot);
	}
	
	

}

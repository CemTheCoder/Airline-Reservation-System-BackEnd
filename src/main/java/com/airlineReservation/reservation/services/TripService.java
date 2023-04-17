package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.TripDao;
import com.airlineReservation.reservation.entities.Trip;

import com.airlineReservation.reservation.requests.TripRequest;

@Service
public class TripService {

	@Autowired
	private TripDao dao;
	
	public Trip trip(int id) {
		return this.dao.findById(id);
	}
	
	public List<Trip> trips() {
		return this.dao.findAll();
	}
	
	public Trip create(String takeOffPoint , String destination , String takeOffTime , String returnTime , double price) {
		Trip t = new Trip();
		t.setTakeOffPoint(takeOffPoint);
		t.setDestination(destination);
		t.setTakeOffTime(takeOffTime);
		t.setReturnTime(returnTime);
		t.setPrice(price);
		return this.dao.save(t);
	}
	
	public Trip update(int id , TripRequest r) {
		Trip t = this.dao.findById(id);
		t.setAirPlanes(r.getAirPlanes());
		t.setDestination(r.getDestination());
		t.setReturnTime(r.getReturnTime());
		t.setTakeOffPoint(r.getTakeOffPoint());
		t.setTakeOffTime(r.getTakeOffTime());
		return this.dao.save(t);
	}
	
	public void delete(int id) {
		Trip t = this.dao.findById(id);
		this.dao.delete(t);
	}
	
	
	public List<Trip> tripsBy(String takeOffPoint , String destination , String takeOffTime , String returnTime , int type) {
		
		if(returnTime.equals("null")) {
			return this.dao.search(takeOffPoint, destination,"%" + takeOffTime.substring(0,15)+"%","%"+ "" +"%",type);
		}
		else  {
			return this.dao.search(takeOffPoint, destination,"%" + takeOffTime.substring(0,15)+"%","%"+ returnTime.substring(0,15)+"%",type);
		}
		
		
		
	}
	
	

}

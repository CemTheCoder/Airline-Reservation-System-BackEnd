package com.airlineReservation.reservation.requests;

import com.airlineReservation.reservation.entities.Trip;
import com.airlineReservation.reservation.entities.User;



public class TicketRequest {

	private int id;
	
	
	private double price;
	
	
	private User user;
	
	
	private Trip trip;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	
	
}

package com.airlineReservation.reservation.requests;

import com.airlineReservation.reservation.entities.Trip;
import com.airlineReservation.reservation.entities.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



public class TicketRequest {

	private int id;
	
	
	private String name;
	
	
	private User user;
	
	
	private Trip trip;
	
	
	
	private String seatNumbers;

	
	private double price;
	
	private int userId;
	
	private int tripId;
	
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSeatNumbers() {
		return seatNumbers;
	}


	public void setSeatNumbers(String seatNumbers) {
		this.seatNumbers = seatNumbers;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getTripId() {
		return tripId;
	}


	public void setTripId(int tripId) {
		this.tripId = tripId;
	}


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

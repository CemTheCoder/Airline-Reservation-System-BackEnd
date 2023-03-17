package com.airlineReservation.reservation.requests;

import com.airlineReservation.reservation.entities.Company;
import com.airlineReservation.reservation.entities.Pilot;
import com.airlineReservation.reservation.entities.Trip;



public class AirPlaneRequest {

	
	private int id;
	
	
	private String airplaneModel;
	
	
	private int numberOfSeats;
	
	
	private Pilot pilot;
	
	
	private Company company;

	
	private Trip trip;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAirplaneModel() {
		return airplaneModel;
	}


	public void setAirplaneModel(String airplaneModel) {
		this.airplaneModel = airplaneModel;
	}


	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public Pilot getPilot() {
		return pilot;
	}


	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	
	
	
	

}

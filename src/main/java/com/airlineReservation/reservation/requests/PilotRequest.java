package com.airlineReservation.reservation.requests;

import java.util.List;

import com.airlineReservation.reservation.entities.AirPlane;



public class PilotRequest {

	private int id;

	private String name;
	
	private String surname;
	
	private List<AirPlane> airPlanes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<AirPlane> getAirPlanes() {
		return airPlanes;
	}

	public void setAirPlanes(List<AirPlane> airPlanes) {
		this.airPlanes = airPlanes;
	}
	
	

}

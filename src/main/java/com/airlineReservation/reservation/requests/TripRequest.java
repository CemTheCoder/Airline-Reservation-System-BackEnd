package com.airlineReservation.reservation.requests;

import java.util.List;

import com.airlineReservation.reservation.entities.AirPlane;



public class TripRequest {

private int id;
	
	private String takeOffPoint;
	
	private String destination;
	
	private String takeOffTime;
	
	private String returnTime;
	
	private List<AirPlane> airPlanes;
	
	private double price;
	
	private String type;
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTakeOffPoint() {
		return takeOffPoint;
	}

	public void setTakeOffPoint(String takeOffPoint) {
		this.takeOffPoint = takeOffPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public List<AirPlane> getAirPlanes() {
		return airPlanes;
	}

	public void setAirPlanes(List<AirPlane> airPlanes) {
		this.airPlanes = airPlanes;
	}
	

}

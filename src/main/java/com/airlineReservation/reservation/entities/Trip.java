package com.airlineReservation.reservation.entities;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "trips")
public class Trip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "take_off_point")
	private String takeOffPoint;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "take_off_time")
	private String takeOffTime;
	
	@Column(name = "start")
	private String start;
	
	@Column(name = "end")
	private String end;
	
	@Column(name = "num_of_passengers")
	private String numOfPassengers;

	@Column(name = "price")
	private double price;
	
	
	
	
	
	


	public String getNumOfPassengers() {
		return numOfPassengers;
	}

	public void setNumOfPassengers(String numOfPassengers) {
		this.numOfPassengers = numOfPassengers;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "trip")
	private List<AirPlane> airPlanes;

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

	

	public List<AirPlane> getAirPlanes() {
		return airPlanes;
	}

	public void setAirPlanes(List<AirPlane> airPlanes) {
		this.airPlanes = airPlanes;
	}
	
	

	
	

}

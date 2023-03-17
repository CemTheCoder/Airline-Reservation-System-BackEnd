package com.airlineReservation.reservation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "airplanes")
public class AirPlane {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "airplaneModel")
	private String airplaneModel;
	
	@Column(name = "number_of_seats")
	private int numberOfSeats;
	
	@ManyToOne()
	@JoinColumn(name = "pilot_id" , referencedColumnName = "id")
	private Pilot pilot;
	
	@ManyToOne()
	@JoinColumn(name = "company_id" , referencedColumnName = "id")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "trip_id" , referencedColumnName = "id")
	private Trip trip;
	
	
	
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

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
	
	
	

	

}

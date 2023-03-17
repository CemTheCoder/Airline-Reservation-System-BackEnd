package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Trip;

@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {
	
	public Trip findById(int id);

}

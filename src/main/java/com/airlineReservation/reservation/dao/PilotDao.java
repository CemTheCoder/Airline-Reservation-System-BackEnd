package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Pilot;

@Repository
public interface PilotDao extends JpaRepository<Pilot, Integer> {
	
	public Pilot findById(int id);

}

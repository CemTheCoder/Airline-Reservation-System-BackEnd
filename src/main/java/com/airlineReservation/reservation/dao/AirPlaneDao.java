package com.airlineReservation.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.AirPlane;

@Repository
public interface AirPlaneDao extends JpaRepository<AirPlane, Integer>{
	
	public AirPlane findById(int id);

}

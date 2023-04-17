package com.airlineReservation.reservation.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Trip;


@Repository
public interface TripDao extends JpaRepository<Trip, Integer> {
	
	public Trip findById(int id);
	
	@Query("select t from Trip t where takeOffPoint = ?1 and destination = ?2 and takeOffTime like ?3 and returnTime like ?4 and type = ?5")
	public List<Trip> search(String takeOffPoint,String destination,String takeOffTime , String returnTime , int type);
	

	
	

}

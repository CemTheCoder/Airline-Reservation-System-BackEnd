package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.City;

@Repository
public interface CityDao extends JpaRepository<City, Integer>{
	
	public City findById(int id);

}

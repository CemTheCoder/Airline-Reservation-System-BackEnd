package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.CityDao;
import com.airlineReservation.reservation.entities.City;

import com.airlineReservation.reservation.requests.CityRequest;


@Service
public class CityService {
	
	@Autowired
	private CityDao dao;
	
	
	public City city(int id) {
		return this.dao.findById(id);
	}
	
	public List<City> cities() {
		return this.dao.findAll();
	}
	
	public City create(City c) {
		return this.dao.save(c);
	}
	
	public City update(int id , CityRequest r) {
		City city = this.dao.findById(id);
		if(r.getNameOfCity() != null) {
		city.setNameOfCity(r.getNameOfCity());
		}
		return this.dao.save(city);
	}
	
	public void delete(int id) {
		City city = this.dao.findById(id);
		this.dao.delete(city);
	}

}

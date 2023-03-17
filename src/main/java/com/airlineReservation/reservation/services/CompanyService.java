package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.CompanyDao;
import com.airlineReservation.reservation.entities.Company;
import com.airlineReservation.reservation.requests.CompanyRequest;


@Service
public class CompanyService {

	@Autowired
	private CompanyDao dao;
	
	
	public Company company(int id) {
		return this.dao.findById(id);
	}
	
	public List<Company> companies() {
		return this.dao.findAll();
	}
	
	public Company create(Company c) {
		return this.dao.save(c);
	}
	
	public Company update(int id,CompanyRequest r) {
		Company c = this.dao.findById(id);
		if(r.getName()!=null) {
			c.setName(r.getName());
		}
		if(r.getAirPlanes()!=null) {
			c.setAirPlanes(r.getAirPlanes());
		}
		return this.dao.save(c);
	}
	
	public void delete(int id) {
		Company c = this.dao.findById(id);
		this.dao.delete(c);
	}
	
	

}

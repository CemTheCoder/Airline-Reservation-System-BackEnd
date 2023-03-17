package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Company;

@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{
	
	public Company findById(int id);

}

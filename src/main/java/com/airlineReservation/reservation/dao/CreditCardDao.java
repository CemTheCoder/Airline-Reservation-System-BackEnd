package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.CreditCard;

@Repository
public interface CreditCardDao extends JpaRepository<CreditCard, Integer> {
	
	public CreditCard findById(int id);

}

package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {
	
	public Ticket findById(int id);

	
}

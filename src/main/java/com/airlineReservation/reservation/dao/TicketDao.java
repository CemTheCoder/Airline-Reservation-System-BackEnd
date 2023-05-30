package com.airlineReservation.reservation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.Ticket;
import com.airlineReservation.reservation.entities.User;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer> {
	
	public Ticket findById(int id);
	
	public List<Ticket> findByUser(User u);

	
}

package com.airlineReservation.reservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airlineReservation.reservation.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	public User findById(int id);
	
	public User findByEmail(String email);

}

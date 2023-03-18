package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.UserDao;
import com.airlineReservation.reservation.entities.User;
import com.airlineReservation.reservation.requests.UserRequest;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User user(int id) {
		return this.dao.findById(id);
	}
	
	public User getOneUserByEmail(String email) {
		return dao.findByEmail(email);
	}
	
	public List<User> users() {
		return this.dao.findAll();
	}
	
	public User create(User u) {
		return this.dao.save(u);
	}
	
	public User update(int id , UserRequest r) {
		User u  = this.dao.findById(id);
		u.setEmail(r.getEmail());
		u.setName(r.getName());
		u.setPassword(r.getPassword());
		u.setSurname(r.getSurname());
		return this.dao.save(u);
		
	}
	
	public void delete(int id) {
		User user = this.dao.findById(id);
		this.dao.delete(user);
	}
	
	

}

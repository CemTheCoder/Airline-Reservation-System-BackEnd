package com.airlineReservation.reservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.UserDao;
import com.airlineReservation.reservation.entities.User;
import com.airlineReservation.reservation.security.JwtUserDetails;

@Service
public class UserDetailServiceImp implements UserDetailsService{
	@Autowired
	private UserDao dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = dao.findByEmail(email);
		return JwtUserDetails.create(user);
	}
	
	
	public UserDetails loadUserById(int id ) {
		User user = dao.findById(id);
		return JwtUserDetails.create(user);
	}

}

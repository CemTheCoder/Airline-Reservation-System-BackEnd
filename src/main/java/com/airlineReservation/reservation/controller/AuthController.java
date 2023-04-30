package com.airlineReservation.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlineReservation.reservation.dao.UserDao;
import com.airlineReservation.reservation.entities.User;
import com.airlineReservation.reservation.requests.UserRequest;
import com.airlineReservation.reservation.responses.AuthResponse;
import com.airlineReservation.reservation.security.JwtTokenProvider;
import com.airlineReservation.reservation.services.UserService;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider provider;
	
	@Autowired
	private UserDao dao;
	
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = provider.generateJwtToken(auth);
		User user = userService.getOneUserByEmail(loginRequest.getEmail());
		AuthResponse authResponse = new AuthResponse();
		authResponse.setMessage("Bearer " + jwtToken);
		authResponse.setUserId(user.getId());
		authResponse.setRoleId(user.getRoleId());
		return authResponse ;
	}
	
	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register (@RequestBody UserRequest registerRequest) {
		AuthResponse authResponse = new AuthResponse();
		if(userService.getOneUserByEmail(registerRequest.getEmail()) != null) {
			authResponse.setMessage("Email already in use.");
			return new ResponseEntity<>(authResponse,HttpStatus.BAD_REQUEST);
		}
		else {
		User user = new User();
		user.setEmail(registerRequest.getEmail());
		user.setName(registerRequest.getName());
		user.setSurname(registerRequest.getSurname());
		user.setPassword(encoder.encode(registerRequest.getPassword()));
		user.setRoleId(2);
		userService.create(user);
		
		authResponse.setMessage("User succesfully registered.");
		return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
		}
		}

}

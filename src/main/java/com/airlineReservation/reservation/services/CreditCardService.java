package com.airlineReservation.reservation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airlineReservation.reservation.dao.CreditCardDao;
import com.airlineReservation.reservation.entities.CreditCard;
import com.airlineReservation.reservation.entities.Pilot;
import com.airlineReservation.reservation.requests.CreditCardRequest;
import com.airlineReservation.reservation.requests.PilotRequest;


@Service
public class CreditCardService {
	
	@Autowired
	private CreditCardDao dao;
	
	@Autowired
	private UserService userService;
	
	public CreditCard creditCard(int id) {
		return this.dao.findById(id);
	}
	
	public List<CreditCard> creditCards() {
		return this.dao.findAll();
	}
	
	public CreditCard create(CreditCardRequest r) {
		CreditCard c = new CreditCard();
		c.setBalance(100000);
		c.setCardName(r.getCardName());
		c.setCardNumber(r.getCardNumber());
		c.setCvc(r.getCvc());
		c.setDate(r.getDate());
		
		com.airlineReservation.reservation.entities.User user = this.userService.user(r.getUserId());
		
		c.setUser(user);
		return this.dao.save(c);
	}
	
	public CreditCard update(int id , CreditCardRequest r) {
		CreditCard creditCard = this.dao.findById(id);
		creditCard.setBalance(r.getBalance());
		creditCard.setCardName(r.getCardName());
		creditCard.setCardNumber(r.getCardNumber());
		creditCard.setCvc(r.getCvc());
		creditCard.setDate(r.getDate());
		creditCard.setUser(r.getUser());
		return this.dao.save(creditCard);
	}
	
	public void delete(int id) {
		CreditCard creditCard = this.dao.findById(id);
		this.dao.delete(creditCard);
	}
	

}

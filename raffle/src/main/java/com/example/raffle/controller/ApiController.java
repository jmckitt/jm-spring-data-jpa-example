package com.example.raffle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.raffle.model.Raffle;
import com.example.raffle.model.Ticket;
import com.example.raffle.model.User;
import com.example.raffle.service.RaffleService;
import com.example.raffle.service.TicketService;
import com.example.raffle.service.UserService;

@RestController
@RequestMapping("/api/raffle")
public class ApiController {
	
	@Autowired
	UserService userService;

	@Autowired
	TicketService ticketService;
	
	@Autowired
	RaffleService raffleService;
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
		
	@RequestMapping(value = "/ticket", method = RequestMethod.POST, produces = "application/json")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}
	
	@RequestMapping(value = "/raffle", method = RequestMethod.POST, produces = "application/json")
	public Raffle createRaffle() {
		return raffleService.createRaffle();
	}
	
}

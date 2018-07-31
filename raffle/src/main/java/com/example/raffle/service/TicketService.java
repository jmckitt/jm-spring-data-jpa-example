package com.example.raffle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.raffle.model.Ticket;
import com.example.raffle.repository.CustomTicketRepository;

@Service
public class TicketService {

	public static final Integer MAX_TICKETS_PER_USER = 10;
	
	@Autowired
	CustomTicketRepository ticketRepository;
	
	public Ticket createTicket(Ticket ticket) {
	
		List<Ticket> tickets = ticketRepository.findByUser(ticket.getUser());
		
		if(tickets.size() >= MAX_TICKETS_PER_USER) {
			throw new IllegalArgumentException(String.format("Only %d tickets may be purchased by a single user.", MAX_TICKETS_PER_USER));
		}
		
		return ticketRepository.save(ticket);
	}
	
}

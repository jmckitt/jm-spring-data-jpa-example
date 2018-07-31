package com.example.raffle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.raffle.model.Raffle;
import com.example.raffle.model.Ticket;
import com.example.raffle.repository.CustomTicketRepository;
import com.example.raffle.repository.RaffleRepository;

@Service
public class RaffleService {

	@Autowired
	RaffleRepository raffleRepository;
	
	@Autowired
	CustomTicketRepository ticketRepository;
	
	public Raffle createRaffle() {
		
		List<Ticket> winningTickets = ticketRepository.findWinningTickets();
		
		Raffle raffle = new Raffle();
		raffle = raffleRepository.save(raffle);
		
		for(Ticket ticket:winningTickets) {
			ticket.setRaffle(raffle);
		}
		
		winningTickets = ticketRepository.saveAll(winningTickets);
		raffle.setWinningTickets(winningTickets);
		
		return raffleRepository.save(raffle);
	}
	
	
}

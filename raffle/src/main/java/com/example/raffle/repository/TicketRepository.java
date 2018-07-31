package com.example.raffle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.raffle.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
	
}

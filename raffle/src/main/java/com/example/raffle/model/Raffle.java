package com.example.raffle.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Raffle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@OneToMany(mappedBy = "raffle")
	private List<Ticket> winningTickets;

	public Raffle() { 
		
	}
	
	
	public Raffle(List<Ticket> winningTickets) {
		this.winningTickets = winningTickets;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Ticket> getWinningTickets() {
		return winningTickets;
	}


	public void setWinningTickets(List<Ticket> winningTickets) {
		this.winningTickets = winningTickets;
	}

}

package com.example.raffle.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.example.raffle.model.Ticket;
import com.example.raffle.model.User;
import com.example.raffle.repository.CustomTicketRepository;

// just an example of a unit test
public class TicketServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void testMaxTicketsPurchase() {
		@SuppressWarnings("unchecked")
		List<Ticket> mockTicketList = mock(List.class);
		when(mockTicketList.size()).thenReturn(11);
		
		User user = new User();
		
		CustomTicketRepository mockRepository = mock(CustomTicketRepository.class);
		when(mockRepository.findByUser(user)).thenReturn(mockTicketList);
		
		TicketService ticketService = new TicketService();
		
		ticketService.ticketRepository = mockRepository;
		
		ticketService.createTicket(new Ticket(user));
	}

}

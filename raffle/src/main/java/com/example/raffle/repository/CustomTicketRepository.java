package com.example.raffle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.raffle.model.Ticket;
import com.example.raffle.model.User;

public interface CustomTicketRepository extends TicketRepository {

	List<Ticket> findByUser(User user);

	// NOTE: This query should exclude winners of the last raffle and tickets which
	// have already won. It needs further cleanup for performance and to cover a tie
	// score on match and exclude users who have already won twice
	@Query(value = "select * from ticket where id in(select id from (select id,email,abs(length(name) - (select avg(length(name)) from USER)) from (select user.email, user.name, eligible.id from user inner join (select * from ticket where raffle_id is null and email not in (select distinct(email) from ticket where raffle_id=(select id from raffle order by id desc limit 1))) as eligible on eligible.email = user.email) limit 1));", nativeQuery = true)
	List<Ticket> findWinningTickets();

}

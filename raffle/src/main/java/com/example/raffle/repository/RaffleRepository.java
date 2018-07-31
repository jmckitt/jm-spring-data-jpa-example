package com.example.raffle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.raffle.model.Raffle;

@Repository
public interface RaffleRepository  extends JpaRepository<Raffle,Integer> {

}

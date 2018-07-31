package com.example.raffle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.raffle.model.User;
import com.example.raffle.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
		
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
}

package com.insopor.usersapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.github.javafaker.Faker;
import com.insopor.usersapp.models.User;

import jakarta.annotation.PostConstruct;


@Service
public class UserService {
	
	
	@Autowired
	private Faker faker;
	
	private List<User> users = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		
		for (int i = 0; i < 100; i++) {
			
			users.add(new User(
					faker.harryPotter().character()
					, faker.name().username()
					, faker.harryPotter().character()
					));
			
		}
		
	}
	
	public List<User> getUsers(String startwith){
		if(startwith != null) {
			return users.stream().filter(
					u -> u.getUsername().startsWith(startwith)).collect(Collectors.toList());
		}else {
			return users;
		}
	}
	
	public User getUserByUsername(String username) {
		return users.stream().filter(
				u -> u.getUsername().equals(username)).findAny().orElseThrow(
						() -> new ResponseStatusException(
								HttpStatus.BAD_REQUEST
								, String.format("User name is not exist", username)
								));
		
	}
	
	public User createUser(User user) {
		if(users.stream().anyMatch(
				u -> u.getUsername().equals(user.getUsername()))) {
			throw new ResponseStatusException(
					HttpStatus.CONFLICT
					, String.format("user %s is already exist", user.getUsername()) 
					);
			
		}else {
			users.add(user);
			return user;
		}

	}
	
	public User updateUser(User user, String username) {
		
		User userToBeUpdate = getUserByUsername(username);
		userToBeUpdate.setNickname(user.getNickname());
		userToBeUpdate.setPassword(user.getPassword());
		
		return userToBeUpdate;
	}
	
	public void deleteUser(String username) {
		User usertobeDeleted = getUserByUsername(username);
		users.remove(usertobeDeleted);
	}

}

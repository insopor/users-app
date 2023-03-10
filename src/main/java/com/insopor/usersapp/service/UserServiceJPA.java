package com.insopor.usersapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.insopor.usersapp.entitys.User;
import com.insopor.usersapp.repositorys.UserRepository;

@Service
public class UserServiceJPA {

	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers(){
		return repository.findAll();
	}
	
	public Page<User> getUserPage(int page, int size){
		return repository.findAll(PageRequest.of(page, size));
	}
	
	public List<String> getUsernames(){
		return repository.findUsernames();
	}
	
	public User getUserById(Integer userId) {
		return repository.findById(userId).orElseThrow(
				() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND
						, String.format("user %d not found", userId)
						));
	}
	
	public User getUserByUsername(String username) {
		return repository.findByUsername(username).orElseThrow(
				() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND
						, String.format("user %d not found", username)
						));
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		return repository.findByUsernameAndPassword(username, password).orElseThrow(
				() -> new ResponseStatusException(
						HttpStatus.NOT_FOUND
						, String.format("user %d not found", username)
						));
	}
	
	
}

package com.insopor.usersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insopor.usersapp.entitys.User;
import com.insopor.usersapp.service.UserServiceJPA;

@RestController
@RequestMapping("/usersjpa")
public class UserControllerJPA {

	@Autowired
	private UserServiceJPA service;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer iserId){
		return new ResponseEntity<User>(service.getUserById(iserId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/username/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<User>(service.getUserByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/autentica")
	public ResponseEntity<User> authenticate(@RequestBody User user){
		return new ResponseEntity<User>(service.getUserByUsernameAndPassword(
				user.getUsername(), user.getPassword()),HttpStatus.OK);
	}
	
}

package com.insopor.usersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insopor.usersapp.models.User;
import com.insopor.usersapp.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(
			@RequestParam(value = "startwith", required = false) String startwith){
		return new ResponseEntity<List<User>>(service.getUsers(startwith), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
		return new ResponseEntity<User>(service.getUserByUsername(username), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUsername(@RequestBody User user){
		return new ResponseEntity<User>(service.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{username}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("username") String username){
		return new ResponseEntity<User>(service.updateUser(user, username), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{username}")
	public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
		service.deleteUser(username);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}

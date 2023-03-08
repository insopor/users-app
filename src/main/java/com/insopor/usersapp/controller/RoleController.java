package com.insopor.usersapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insopor.usersapp.entitys.Role;
import com.insopor.usersapp.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	
	@Autowired
	private RoleService service;
	
	@GetMapping("/getroles")
	public ResponseEntity<List<Role>> getRoles(){
		return new ResponseEntity<List<Role>>(service.getRoles(), HttpStatus.OK);
	}
	
	@PostMapping("/crearrole")
	public ResponseEntity<Role> createRole(@RequestBody Role role){
		return new ResponseEntity<Role>(service.createRole (role), HttpStatus.CREATED);
	}
}

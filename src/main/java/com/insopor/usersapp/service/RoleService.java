package com.insopor.usersapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.insopor.usersapp.entitys.Role;
import com.insopor.usersapp.repositorys.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getRoles(){
		return repository.findAll();
	}
	
	public Role createRole(Role role) {
		return repository.save(role);
	}
	
	public Role upDateRole(Integer roleId, Role role) {
		Optional<Role> result = repository.findById(roleId);
		
		if(result.isPresent()) {
			return repository.save(role);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
					String.format("Role ID doesn´t $d exist", roleId));
		}
	}


}

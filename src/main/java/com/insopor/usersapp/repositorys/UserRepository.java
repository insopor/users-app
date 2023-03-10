package com.insopor.usersapp.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public Optional<User> findByUsername (String username);
	
	public Optional<User> findByUsernameAndPassword(String username, String password);
}

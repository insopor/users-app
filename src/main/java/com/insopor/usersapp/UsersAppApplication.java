package com.insopor.usersapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.javafaker.Faker;
import com.insopor.usersapp.entitys.User;
import com.insopor.usersapp.repositorys.UserRepository;

@SpringBootApplication
public class UsersAppApplication implements ApplicationRunner{

	@Autowired
	private Faker faker;
	
	@Autowired
	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(UsersAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 10000; i++) {
			
			User user = new User();
			
			user.setUsername(faker.name().username());
			user.setPassword(faker.harryPotter().character());
			user.setProfile(null);
			
			repository.save(user);
			
		}
		
		
	}

}

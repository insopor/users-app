package com.insopor.usersapp.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}

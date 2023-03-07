package com.insopor.usersapp.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

}

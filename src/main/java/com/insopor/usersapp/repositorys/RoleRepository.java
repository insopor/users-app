package com.insopor.usersapp.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

package com.insopor.usersapp.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}

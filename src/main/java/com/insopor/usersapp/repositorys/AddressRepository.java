package com.insopor.usersapp.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insopor.usersapp.entitys.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>{

}

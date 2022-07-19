package com.example.microservices.UserExample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.microservices.UserExample.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}

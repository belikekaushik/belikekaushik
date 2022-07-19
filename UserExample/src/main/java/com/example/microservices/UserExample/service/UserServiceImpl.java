package com.example.microservices.UserExample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.microservices.UserExample.entity.User;
import com.example.microservices.UserExample.repository.AccountRepository;
import com.example.microservices.UserExample.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<User> getAllUsersService() {
		
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public Optional<User> getUsersById(Integer id) {
		
		return userRepository.findById(id);
	}

	@Override
	public User userAddService(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public User userUpdate(Integer id, User user) {
		
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public String userRemoveService(Optional<User> user) {
		// TODO Auto-generated method stub
		userRepository.deleteById(user.get().getId());
		return "User has been deleted";
	}


}

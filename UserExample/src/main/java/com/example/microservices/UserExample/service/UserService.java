package com.example.microservices.UserExample.service;

import java.util.List;
import java.util.Optional;

import com.example.microservices.UserExample.entity.User;

public interface UserService {
	
	public List<User> getAllUsersService();
	
	public Optional<User> getUsersById(Integer id);
	
	public User userAddService(User user);
	
	public User userUpdate(Integer id, User user);
	
	public String userRemoveService(Optional<User> existingUser);

}

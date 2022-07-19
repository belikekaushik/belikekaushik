package com.example.microservices.UserExample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservices.UserExample.entity.Account;
import com.example.microservices.UserExample.entity.User;
import com.example.microservices.UserExample.exceptionHandler.ApiException;
import com.example.microservices.UserExample.exceptionHandler.UserNotFoundException;
import com.example.microservices.UserExample.service.UserService;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping("/users") 
	public List<User> getUsers(){
		return this.userService.getAllUsersService();
	}
	
	@GetMapping("/users/{id}") 
	public User getUsersById(@PathVariable Integer id){
		return this.userService.getUsersById(id).orElseThrow(()-> new UserNotFoundException("User not found with id :" + id));
	}

	@PostMapping("/users") 
	public ResponseEntity<User> createUsers(@RequestBody User user){
		try {
			return new ResponseEntity<>(userService.userAddService(user),HttpStatus.CREATED);
		}
		catch(Exception e) {
			throw new ApiException("Internal Server Error");
		}
	}

	@PutMapping("/users/{id}") 
	public ResponseEntity<User> updateUsers(@PathVariable Integer id, @RequestBody User user){
		
		Optional<User> existingUser = Optional.ofNullable(this.userService.getUsersById(id).orElseThrow(()-> new UserNotFoundException("User not found with id :" + id)));
		if(existingUser.isPresent()) {
			User users = new User();
			Account account = new Account();
			if(users!=null && account!=null) {
			users.setId(user.getId());
			users.setUserCity(user.getUserCity());
			users.setUserName(user.getUserName());
			users.setUserIncome(user.getUserIncome());
			account.setAccountId(user.getAccount().getAccountId());
			account.setAccountPassword(user.getAccount().getAccountPassword());
			users.setAccount(account);
			}
			return new  ResponseEntity<>(userService.userUpdate(id, users),HttpStatus.OK);

		}

		else {
			throw new UserNotFoundException("User not found with id :" + id);
		}
	}

	@DeleteMapping("/users/{id}") 
	public ResponseEntity<User> deleteUsers(@PathVariable Integer id){
		try {
			Optional<User> existingUser = Optional.ofNullable(this.userService.getUsersById(id).orElseThrow(()-> new UserNotFoundException("User not found with id :" + id)));
			if(existingUser.isPresent());
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new ApiException("Internal Server Error");
		}
	}
}

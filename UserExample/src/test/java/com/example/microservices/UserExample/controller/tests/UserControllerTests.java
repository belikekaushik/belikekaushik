//package com.example.microservices.UserExample.controller.tests;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.microservices.UserExample.controller.UserController;
//import com.example.microservices.UserExample.entity.User;
//import com.example.microservices.UserExample.service.UserService;
//
//@SpringBootTest
//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserControllerTests {
//
//	@Mock
//	public UserService userService;
//
//	@InjectMocks
//	public UserController userController;
//
//	@Test
//	public void getAllUsersTest() {
//		
//		List<User> userList = new ArrayList<User>();
//		
//		User user = new User();
//		user.setId(3);
//		user.setUserName("Parmesh");
//		user.setUserCity("Bangalore");
//		user.setUserIncome(40000);
//		
//		userList.add(user);
//		Mockito.when(userService.getAllUsersService()).thenReturn(userList);
//	}
//	
//	@Test
//	public void getUsers() {
//		
//		Optional<User> user = Optional.ofNullable(new User());
//		
//		Integer id = user.get().getId();
//		user.get().setUserName("Harish");
//		user.get().setUserCity("Chennai");
//		user.get().setUserIncome(1223);
//		
//		Mockito.when(userService.getUsersById(id)).thenReturn(user);
//	}
//
//}

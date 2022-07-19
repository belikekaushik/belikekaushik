package com.example.microservices.UserExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.microservices.UserExample.entity.Account;
import com.example.microservices.UserExample.entity.User;
import com.example.microservices.UserExample.repository.UserRepository;

@Component
public class DemoCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User();
		Account account1 = new Account();
		user1.setId(1);
		user1.setUserName("Shubham");
		user1.setUserCity("Delhi");
		user1.setUserIncome(2000);
		user1.setAddress("Janakpuri, Delhi");
		account1.setAccountId(1234);
		account1.setAccountPassword("Shubh1234");
		user1.setAccount(account1);
		
		userRepository.save(user1);

		User user2 = new User();
		Account account2 = new Account();
		user2.setId(2);
		user2.setUserName("Ramesh");
		user2.setUserCity("Mumbai");
		user2.setUserIncome(10000);
		user2.setAddress("Andheri, Mumbai");
		account2.setAccountId(7890);
		account2.setAccountPassword("Ramesh7890");
		user2.setAccount(account2);
		
		userRepository.save(user2);

		// findByUserName
		List<User> users = userRepository.findByUserName("Ramesh");
		System.out.println("users = "+ users);

		//findById
		Optional<User> usersById = userRepository.findById(3);
		System.out.println("usersById = "+ usersById);

		//JPQL query getUserByUserCityWithUserName
		User userByQuery = userRepository.getUserByUserCity("Delhi");
		System.out.println("userByQuery "+ userByQuery);

		//JPQL query getUserByUserCityWithUserName
		String userByQueryWithUserName = userRepository.getUserByUserCityWithUserName("Mumbai");
		System.out.println("userByQueryWithUserName "+ userByQueryWithUserName);

		//JPQL query getUserByUserCity
		User userByNativeQuery = userRepository.getUserByUserIncomeNative(10000);
		System.out.println("userByNativeQuery "+ userByNativeQuery);

		//JPQL query getUserByUserCityWithParam
		User userByNativeQueryWithParam = userRepository.getUserByUserIncomeNativeWithParam(10000);
		System.out.println("userByNativeQueryWithParam "+ userByNativeQueryWithParam);

		//JPQL query updateUserNameWithCity
//		int updateUserNameWithCity = userRepository.updateUserNameByUserCity("Hariram","Mumbai");
	//	System.out.println("updateUserNameWithCity "+ updateUserNameWithCity);
		
		// Insert value for User3
//		User user3 = new User();
//		Account account3 = new Account();
////		user3.setId(3);
//		user3.setAddress("Karachi, Pakistan");
//		user3.setUserCity("Karachi");
//	
//		account3.setAccountId(4567);
//		account3.setAccountPassword("Charsi4567");
//		user3.setAccount(account3);
//		
//		userRepository.save(user3);
		
		//InsertValueForUser5
		
//		User user5 = new User();
//		Account account5 = new Account();
//		
//		user5.setId(5);
//		user5.setUserCity("Gurugram");
//		user5.setUserName("Kohli");
//		user5.setUserIncome(2000000);
//		user5.setAddress("Gurugram,Haryana");
//		
//		account5.setAccountId(7540);
//		account5.setAccountPassword("Kohli7540");
//		user5.setAccount(account5);
//		
//		userRepository.save(user5);
		
		
//		//JPQL query updateUserNameWithCity
//		int updateThirdUserByUserId = userRepository.updateUserAddressByUserId("Karachi,Pakistan",3);
//		int updateFourthUserByUserId = userRepository.updateUserAddressByUserId("George Street, London", 4);
//		System.out.println("updateThirdUserByUserId "+ updateThirdUserByUserId);
//		System.out.println("updateFourthUserByUserId "+ updateFourthUserByUserId);
		

	}
}

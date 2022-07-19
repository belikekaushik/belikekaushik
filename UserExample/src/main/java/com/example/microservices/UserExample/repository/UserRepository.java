package com.example.microservices.UserExample.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.microservices.UserExample.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByUserName(String userName);

	Optional<User> findById(Integer id);

	@Query("select u from User u where u.userCity=?1")
	User getUserByUserCity(String userCity);

	//QueryWithUserName
	@Query("select u.userName from User u where u.userCity=?1")
	String getUserByUserCityWithUserName(String userCity);

	//NativeQuery
	@Query(value = "select * from user u where u.user_income =?1 ",
			nativeQuery = true
			)
	User getUserByUserIncomeNative(Integer userIncome);

	//NativeQueryWithParam
	@Query(value = "select * from user u where u.user_income =:userIncome ",
			nativeQuery = true
			)
	User getUserByUserIncomeNativeWithParam(@Param("userIncome") Integer userIncome);

//	//NativeQuery
//	@Modifying
//	@Transactional
//	@Query(value = "update user set user_name = ?1 where user_city = ?2",
//	nativeQuery = true
//			)
//	int updateUserNameByUserCity(String userName, String userCity);
//
//	//UpdateUserAddressByUserId
//	@Modifying
//	@Transactional
//	@Query(value = "update user set user_address = ?1 where user_id = ?2",
//	nativeQuery = true
//			)
//	int updateUserAddressByUserId(String userAddress, Integer userId);

}

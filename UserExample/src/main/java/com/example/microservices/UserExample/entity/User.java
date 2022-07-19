package com.example.microservices.UserExample.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "user")
public class User {

	@Id
	@SequenceGenerator(name = "user_sequence",allocationSize = 1,sequenceName ="user_sequence" )
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_sequence")
	@NonNull
	@Column(name = "user_id", nullable = false)
	private Integer id;
	@Column(name = "user_name",nullable = false)
	private String userName;
	@Column(name = "user_city",nullable=false)
	private String userCity;
	@Column(name = "user_income",nullable=false)
	private Integer userIncome;
	@Column(name = "user_address",nullable=false)
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(	
			name = "account_id", nullable = false)
	private Account account;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		super();
		
	}

	public User(Integer id, String userName, String userCity, Integer userIncome) {
		super();
		this.id = id;
		this.userName = userName;
		this.userCity = userCity;
		this.userIncome = userIncome;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public Integer getUserIncome() {
		return userIncome;
	}
	public void setUserIncome(Integer userIncome) {
		this.userIncome = userIncome;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userCity=" + userCity + ", userIncome=" + userIncome
				+ "]";
	}

}

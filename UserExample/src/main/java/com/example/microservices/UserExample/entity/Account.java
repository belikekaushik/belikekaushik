package com.example.microservices.UserExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="account")
public class Account {

	@Id
	@SequenceGenerator(name = "account_sequence",allocationSize = 1,sequenceName ="account_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_sequence" )
	@Column(name="account_id", nullable = false)
	private Integer accountId;

	@Column(name="password", nullable = false)
	private String accountPassword;



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accountId, String accountPassword) {
		super();
		this.accountId = accountId;
		this.accountPassword = accountPassword;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

}

package com.webapp.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {
	
	// using entity class save tjhe registration in databse :
	
	@Id
	// this is used for auto increment of id no 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name", nullable = false , length = 100)
	private String firstname;
	
	@Column(name="email_id" , nullable = false , unique = true , length = 255)
	private String email;
	
	@Column(name="mobile", nullable = false , unique = true , length = 255)
	private String mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}

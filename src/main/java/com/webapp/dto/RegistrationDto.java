package com.webapp.dto;

// 3> method to save data in database through pure java class:
//pojo class 
public class RegistrationDto {

	 private String firstname;
	 private String email;
	 private String mobile;
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

package com.bridgelabz.attendence.dto;

import org.springframework.stereotype.Component;

@Component
public class RegisterDto {
	
	private String username;
	private String password;
	private String email;
	private String phoneNo;
	private String role;
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public  String getPhoneNo() {
		return phoneNo;
	}
	public String getRole() {
		return role;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNo( String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

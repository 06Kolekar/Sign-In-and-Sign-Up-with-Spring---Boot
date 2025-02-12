package com.learn.learnak.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDTO {

	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Lastname cannot be empty")
	private String lastname;
	
	@NotBlank(message = "Number cannot be empty")
	private String number;
	
	@Email(message = "Please enter a valid email address")
	private String email;
	
	@NotBlank(message = "Password cannot be empty")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

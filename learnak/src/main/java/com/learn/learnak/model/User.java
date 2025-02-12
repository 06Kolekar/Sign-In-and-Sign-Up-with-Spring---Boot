package com.learn.learnak.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastname;
	private String number;
	private String email;
	private String password;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String lastname, String number, String email, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.number = number;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getNumber() {
		return number;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", number=" + number + ", email="
				+ email + ", password=" + password + "]";
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

package com.learn.learnak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.learnak.dao.UserDAO;
import com.learn.learnak.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userdao;
	
	public String addUser(User user) {
		return userdao.addUser(user);
	}
	
	public String userEntry(User user) {
		return userdao.enterUser(user);
	}
}

package com.learn.learnak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.learnak.model.User;
import com.learn.learnak.service.UserService;

@RestController
@RequestMapping("/learnakUser")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String response = userService.addUser(user);
		if(response.contains("Failed")) {
			return ResponseEntity.status(500).body(response);
		}
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<String> userEntry(@RequestBody User user) {
		String response = userService.userEntry(user);
		if(response.contains("Failed")) {
			return ResponseEntity.status(500).body(response);
		}
		return ResponseEntity.ok(response);
	}
}

package com.emailDemo.springemailclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emailDemo.springemailclient.dto.UserDto;
import com.emailDemo.springemailclient.entity.User;
import com.emailDemo.springemailclient.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public User signUp(@RequestBody UserDto userDto) {
		User createdUser = userService.createUser(userDto);
//        userService.sendVerificationCode(createdUser);
		return createdUser;
	}

	@PostMapping("/verify")
	public boolean verifyUser(@RequestParam String email, @RequestParam String verificationcode) {
		System.out.println("verified successfully");
		return userService.verifyUser(email, verificationcode);
	}

}

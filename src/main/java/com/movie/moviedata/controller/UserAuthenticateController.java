package com.movie.moviedata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviedata.modal.User;
import com.movie.moviedata.service.UserAuthenticateService;

@RestController
@RequestMapping("/authenticate")
public class UserAuthenticateController {

	@Autowired
	UserAuthenticateService userAuthenticateService;
	
	@PostMapping("/signup")
	public User signup(@RequestBody User inputBody) {
		User result = userAuthenticateService.signup(inputBody);
		return null;
	}
}

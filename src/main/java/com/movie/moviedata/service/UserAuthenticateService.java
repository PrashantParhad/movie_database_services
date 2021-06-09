package com.movie.moviedata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.movie.moviedata.modal.User;

@Service
public class UserAuthenticateService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public User signup(User body) {
		return null;
	}
	
	public User logIn(User body) {
		return null;
	}
}

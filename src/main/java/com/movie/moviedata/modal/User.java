package com.movie.moviedata.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Document(collection="users")
public class User {
	@Id
	private String userId;
	private String userName;
	private String password;
	private String wishlist;
	private String email;

}

package com.movie.moviedata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.movie.moviedata.modal.Movie;

public interface MovieRepository extends MongoRepository<Movie, String>{

}

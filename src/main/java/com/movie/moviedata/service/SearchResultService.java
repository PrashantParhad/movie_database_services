package com.movie.moviedata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.movie.moviedata.modal.Movie;

@Service
public class SearchResultService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Movie> getTitle(String param) {
		Query query = new Query();
		query.addCriteria(Criteria.where("title").is(param));
		List<Movie> result = mongoTemplate.find(query, Movie.class);
		return result;
	}
	
	public List<Movie> getActor(String param) {
		Query query = new Query();
		query.addCriteria(Criteria.where("actors").is(param));
		List<Movie> result = mongoTemplate.find(query, Movie.class);
		return result;
	}
	
	public List<Movie> getGenres(String param) {
		Query query = new Query();
		query.addCriteria(Criteria.where("genres").is(param));
		List<Movie> result = mongoTemplate.find(query, Movie.class);
		return result;
	}
	
	public List<Movie> getTrending() {
		Query query = new Query();
		query.addCriteria(Criteria.where("imdbRating").gt("8"));
		List<Movie> result = mongoTemplate.find(query, Movie.class);
		return result;
	}
	
}

package com.movie.moviedata.service;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.UpdateOptions;
import com.movie.moviedata.modal.Movie;
import com.movie.moviedata.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Optional<Movie> getMovie(String id){
		return movieRepository.findById(id);
	}
	
	public List<Movie> getMovieList(){
		return movieRepository.findAll();
	}
	
	public Document addMovie(Movie movieInput) {
		
		Movie result = mongoTemplate.save(movieInput);
		Document resultDoc = new Document();
		resultDoc.append("id", result.getId());
		return resultDoc;
	}
	
	public Movie updateMovie(String id, Movie body) {
		
		Update update = new Update();
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		update.set("storyline", body.getStoryline());
		update.set("posterurl", body.getPosterurl());
		update.set("imdbRating", body.getImdbRating());
		Movie updateResult  = mongoTemplate.findAndModify(query, update, Movie.class);
		return updateResult;
	}

	
	
}

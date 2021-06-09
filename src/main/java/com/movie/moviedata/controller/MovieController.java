package com.movie.moviedata.controller;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviedata.modal.Movie;
import com.movie.moviedata.repository.MovieRepository;
import com.movie.moviedata.service.MovieService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/v1/movies")
public class MovieController {

	@Autowired
	private  MovieService movieService;

	@GetMapping("/getMovieList/{id}")
	public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String id) {
		try {
			Optional<Movie> movieDetails = movieService.getMovie(id);
			if(movieDetails.isPresent()) {
				return ResponseEntity.ok().body(movieDetails);
				//return ResponseEntity<Optional<Movie>>(movieDetails,HttpStatus.OK);
			}
			else {
				return ResponseEntity.noContent().build();
			}
		} catch(Exception e) {
			return ResponseEntity.status(500).build();	
		}

	}

	@GetMapping("/getMovieList")
	public List<Movie> getMovieList() {
		List<Movie> movieList = movieService.getMovieList();
		return movieList;
	} 

	@PostMapping("/addMovie")
	public ResponseEntity<Document> addMovie(@RequestBody Movie movieInput) {
		try {
			Document result = movieService.addMovie(movieInput);

			return ResponseEntity.ok().body(result);
		} catch(Exception e) {
			return ResponseEntity.status(500).build();	
		}
	} 

	@PostMapping("/updateMovie/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable String id, @RequestBody Movie body) {
		try {
			Movie result = movieService.updateMovie(id,body);
			if(result == null) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok().build();
			}
		} catch(Exception e) {
			return ResponseEntity.status(500).build();	
		}
	}


}

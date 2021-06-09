package com.movie.moviedata.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.moviedata.modal.Movie;
import com.movie.moviedata.service.SearchResultService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/v1/search")
public class SearchResultController {

	@Autowired
	private SearchResultService searchResultService;
	
	@GetMapping("/title/{title}")
	public ResponseEntity<List<Movie>> getTitle(
			@PathVariable String title) {
		try {
		List<Movie> result = searchResultService.getTitle(title);
		if(result != null && !result.isEmpty()) {
			return ResponseEntity.ok().body(result);
		} else {
			return ResponseEntity.noContent().build();
		}
		} catch(Exception e){
		return  ResponseEntity.status(500).build();
		}
	}
	
	@GetMapping("/actors/{actorName}")
	public ResponseEntity<List<Movie>> getActor(@PathVariable String actorName) {
		try {
			List<Movie> result = searchResultService.getActor(actorName);
			if(result != null && !result.isEmpty()) {
				return ResponseEntity.ok().body(result);
			} else {
				return ResponseEntity.noContent().build();
			}
			} catch(Exception e){
			return  ResponseEntity.status(500).build();
			}
	}
	
	@GetMapping("/genres/{genre}")
	public ResponseEntity<List<Movie>> getGenres(@PathVariable String genre) {
		try {
			List<Movie> result = searchResultService.getGenres(genre);
			if(result != null && !result.isEmpty()) {
				return ResponseEntity.ok().body(result);
			} else {
				return ResponseEntity.noContent().build();
			}
			} catch(Exception e){
			return  ResponseEntity.status(500).build();
			}
	}
	
	@GetMapping("/trending")
	public ResponseEntity<List<Movie>> getTrending() {
		try {
			List<Movie> result = searchResultService.getTrending();
			if(result != null && !result.isEmpty()) {
				return ResponseEntity.ok().body(result);
			} else {
				return ResponseEntity.noContent().build();
			}
			} catch(Exception e){
			return  ResponseEntity.status(500).build();
			}
	}
	
}

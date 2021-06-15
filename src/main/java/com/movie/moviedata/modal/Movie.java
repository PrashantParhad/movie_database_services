package com.movie.moviedata.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor //NO NNNED TO UINITIALZE CONSTRCTOR
@Document(collection= "MovieDetails")
public class Movie {
	@Id
	private String id;
	@TextIndexed
	private String title;
	private int year;
	private String[] genres;
	private String posterurl;
	private String releaseDate;
	private String storyline;
	private String[] actors;
	private String imdbRating;
	private String duration;
	private String trailerUrl;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	public String getPosterurl() {
		return posterurl;
	}
	public void setPosterUrl(String posterUrl) {
		this.posterurl = posterUrl;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getStoryline() {
		return storyline;
	}
	public void setStoryline(String storyline) {
		this.storyline = storyline;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTrailerUrl() {
		return trailerUrl;
	}
	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}
	
	
	
	
	
	
}

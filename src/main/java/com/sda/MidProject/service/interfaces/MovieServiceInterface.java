package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;

import java.util.List;

public interface MovieServiceInterface {

    List<Movie> getAllMovies();

    List<Movie> findByMovieCategory(MovieCategory movieCategory);

    String updateMovieInfo(int movieId, Movie movie, Admin admin);

    String deleteMovie(int movieId);

    Movie addMovie(Movie movie, Admin admin) throws Exception;
}

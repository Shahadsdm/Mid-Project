package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;
import com.sda.MidProject.service.implementations.MovieServiceImpl;
import com.sda.MidProject.service.interfaces.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping("/Movies")
    public List<Movie> movies(){
        return movieServiceImpl.getAllMovies() ;
    }

    @GetMapping("/MovieCategory/{movieCategory}")
    public List<Movie> findByMovieCategory(@PathVariable String movieCategory){
        MovieCategory Category = MovieCategory.valueOf(movieCategory.toUpperCase());
        return movieServiceImpl.findByMovieCategory(Category);
    }

    @PutMapping("/updateMovie/{movieId}")
    public String updateMovieInfo(@PathVariable int movieId, @RequestBody Movie movie){
        Admin admin = movie.getAdmin();
        return movieServiceImpl.updateMovieInfo(movieId,movie,admin);
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) throws Exception {
        Admin admin = movie.getAdmin();
        return movieServiceImpl.addMovie(movie, admin);
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable int movieId){
        try{
            String message = movieServiceImpl.deleteMovie(movieId);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            String eerMessage = "Movie not deleted successfully" + e.getMessage();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eerMessage);
        }
    }
}

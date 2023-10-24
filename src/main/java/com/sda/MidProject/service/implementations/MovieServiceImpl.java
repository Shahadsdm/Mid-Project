package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.repository.MovieRepository;
import com.sda.MidProject.service.interfaces.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieServiceInterface {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findByMovieCategory(MovieCategory movieCategory) {
        return movieRepository.findByCategory(movieCategory);
    }

    @Override
    public String updateMovieInfo(int movieId, Movie movie, Admin admin) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isPresent()){
            Movie movie1 = movieOptional.get();
            Admin admin1 = adminRepository.save(admin);

            if (admin1 != null){
                movie1.setTitle(movie.getTitle());
                movie1.setDuration(movie.getDuration());
                movie1.setCategory(movie.getCategory());
                movie1.setRating(movie.getRating());
                movie1.setAdmin(admin1);
                movieRepository.save(movie1);
                return "Movie updated Successfully";
            }else {
                return "Admin not found";
            }
        }else{
            return "Movie not found";
        }
    }

    @Override
    public String deleteMovie(int movieId) {
        if (movieRepository.existsById(movieId)){
            movieRepository.deleteById(movieId);
            return "Movie deleted Successfully";
        }else {
            return "Movie not found";
        }
    }

    @Override
    public Movie addMovie(Movie movie, Admin admin) throws Exception {
        Admin admin1 = adminRepository.save(admin);
        movie.setAdmin(admin1);
        if (movieRepository.existsById(movie.getMovieId())){
            throw new Exception("Movie with ID " + movie.getMovieId() + " already exists.");
        }
        return movieRepository.save(movie);
    }
}

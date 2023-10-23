package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.repository.MovieRepository;
import com.sda.MidProject.service.interfaces.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieServiceInterface {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}

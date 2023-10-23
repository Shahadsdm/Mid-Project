package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.service.implementations.MovieServiceImpl;
import com.sda.MidProject.service.interfaces.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping("/Movies")
    public List<Movie> movies(){
        return movieServiceImpl.getAllMovies() ;
    }
}

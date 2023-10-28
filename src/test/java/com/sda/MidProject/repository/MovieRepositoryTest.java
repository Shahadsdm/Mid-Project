package com.sda.MidProject.repository;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testFindByCategory() {
        Movie movie1 = new Movie(30,"Movie1", 100.0, 8.5, MovieCategory.ACTION, new Admin(1,"Admin1", "admin1@example.com","1234"));
        Movie movie2 = new Movie(40,"Movie2", 120.0, 8.7, MovieCategory.ACTION, new Admin(1,"Admin1", "admin1@example.com","1234"));
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<Movie> movies = movieRepository.findByCategory(MovieCategory.ACTION);

        assertEquals(2, movies.size());
    }
}
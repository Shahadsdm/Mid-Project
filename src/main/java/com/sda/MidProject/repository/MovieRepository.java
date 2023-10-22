package com.sda.MidProject.repository;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie,Integer> {
}

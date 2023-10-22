package com.sda.MidProject;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.MovieCategory;
import com.sda.MidProject.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MidProjectApplicationTests {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RegisterUserRepository registerUserRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private UserRepository userRepository;


	@Test
	void contextLoads() {
	}

	@Test
	void setUp(){

		List<Movie> adminMovies = new ArrayList<>();

		Admin admin = new Admin(1,"Shahad","shahad@gmail.com","12345S","admin",adminMovies);

		adminRepository.save(admin);

	}

}

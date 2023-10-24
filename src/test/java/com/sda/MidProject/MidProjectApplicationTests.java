package com.sda.MidProject;

import com.sda.MidProject.entity.*;
import com.sda.MidProject.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

		Admin admin = new Admin(1, "Admin1", "admin1@example.com");
		Admin admin2 = new Admin(2, "Admin2", "admin2@example.com");
		Admin admin3 = new Admin(3, "Admin3", "admin3@example.com");

		adminRepository.save(admin);
		adminRepository.save(admin2);
		adminRepository.save(admin3);


		Movie movie1 = new Movie(1, "Movie1", 120.0, 8.0, MovieCategory.ACTION, admin);
		Movie movie2 = new Movie(2, "Movie2", 110.0, 7.5, MovieCategory.COMEDY, admin);
		Movie movie3 =new Movie(3, "Movie3", 140.0, 8.5, MovieCategory.HORROR, admin2);

		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);

		RegisterUser registerUser1 = new RegisterUser(4, "User4", "user4@example.com");
		RegisterUser registerUser2 = new RegisterUser(5, "User5", "user5@example.com");
		RegisterUser registerUser3 = new RegisterUser(6, "User6", "user6@example.com");

		registerUserRepository.save(registerUser1);
		registerUserRepository.save(registerUser2);
		registerUserRepository.save(registerUser3);

		Reservation reservation1 = new Reservation();
		Reservation reservation2 = new Reservation();
		Reservation reservation3 = new Reservation();

		reservation1.setMovie(movie1);
		reservation1.setRegisterUser(registerUser1);
		reservation1.setReservationDate(LocalDate.now());

		reservation2.setMovie(movie2);
		reservation2.setRegisterUser(registerUser2);
		reservation2.setReservationDate(LocalDate.now());

		reservation3.setMovie(movie3);
		reservation3.setRegisterUser(registerUser3);
		reservation3.setReservationDate(LocalDate.now());

		reservationRepository.save(reservation1);
		reservationRepository.save(reservation2);
		reservationRepository.save(reservation3);
	}

	@Test
	void clear(){
		reservationRepository.deleteAll();
	}

}

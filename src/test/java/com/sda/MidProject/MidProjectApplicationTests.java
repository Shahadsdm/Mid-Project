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

		// can i put the user class as an abstract class ?

		Admin admin = new Admin(1, "Admin1", "admin1@example.com");
		Admin admin2 = new Admin(2, "Admin2", "admin2@example.com");
		Admin admin3 = new Admin(3, "Admin3", "admin3@example.com");

		adminRepository.save(admin);
		adminRepository.save(admin2);
		adminRepository.save(admin3);


		Movie movie1 = new Movie(1, "Movie1", 120.0, 8.0, MovieCategory.Action, admin);
		Movie movie2 = new Movie(2, "Movie2", 110.0, 7.5, MovieCategory.Comedy, admin);
		Movie movie3 =new Movie(3, "Movie3", 140.0, 8.5, MovieCategory.Horror, admin2);

		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);

		RegisterUser registerUser1 = new RegisterUser(4, "User1", "user1@example.com");
		RegisterUser registerUser2 = new RegisterUser(5, "User2", "user2@example.com");
		RegisterUser registerUser3 = new RegisterUser(6, "User3", "user3@example.com");

		registerUserRepository.save(registerUser1);
		registerUserRepository.save(registerUser2);
		registerUserRepository.save(registerUser3);

		Reservation reservation1 = new Reservation();
		Reservation reservation2 = new Reservation();
		Reservation reservation3 = new Reservation();

//		reservation1.setReservationId(1);
		reservation1.setMovie(movie1);
		reservation1.setRegisterUser(registerUser1);
		reservation1.setReservationDate(LocalDate.now());

//		reservation2.setReservationId(2);
		reservation2.setMovie(movie2);
		reservation2.setRegisterUser(registerUser2);
		reservation2.setReservationDate(LocalDate.now());

//		reservation3.setReservationId(3);
		reservation3.setMovie(movie3);
		reservation3.setRegisterUser(registerUser3);
		reservation3.setReservationDate(LocalDate.now());

		reservationRepository.save(reservation1);
		reservationRepository.save(reservation2);
		reservationRepository.save(reservation3);
	}

}

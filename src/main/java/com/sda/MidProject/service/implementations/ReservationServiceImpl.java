package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.*;
import com.sda.MidProject.repository.MovieRepository;
import com.sda.MidProject.repository.RegisterUserRepository;
import com.sda.MidProject.repository.ReservationRepository;
import com.sda.MidProject.service.interfaces.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RegisterUserRepository registerUserRepository;
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByReservationId(int reservationId) throws Exception {
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
        if (reservationOptional.isPresent()) {
            return reservationOptional.get();
        } else {
            throw new Exception("Reservation not found");
        }
    }

//    @Override
//    public Reservation addReservation(Reservation reservation, Movie movie, RegisterUser registerUser) throws Exception {
//        Movie foundMovie = movieRepository.findById(movie.getMovieId()).get();
//        Movie movie1 = movieRepository.save(foundMovie);
//        RegisterUser foundRegisterUser = registerUserRepository.findById(registerUser.getUserId()).get();
//        RegisterUser user = registerUserRepository.save(foundRegisterUser);
//        reservation.setMovie(movie1);
//        reservation.setRegisterUser(user);
//        if (reservationRepository.existsById(reservation.getReservationId())){
//            throw new Exception("Reservation with ID " + reservation.getReservationId() + " already exists.");
//        }
//        return reservationRepository.save(reservation);
//    }
}

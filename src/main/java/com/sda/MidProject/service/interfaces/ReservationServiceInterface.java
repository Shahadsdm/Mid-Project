package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.entity.Movie;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.entity.Reservation;
import com.sda.MidProject.entity.User;

import java.util.List;

public interface ReservationServiceInterface {

    List<Reservation> getAllReservations();

    Reservation findByReservationId(int reservationId) throws Exception;

    Reservation addReservation(Reservation reservation, Movie movie, User registerUser) throws Exception;
}

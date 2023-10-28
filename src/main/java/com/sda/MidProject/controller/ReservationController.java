package com.sda.MidProject.controller;

import com.sda.MidProject.entity.*;
import com.sda.MidProject.service.implementations.ReservationServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    @GetMapping("/Reservations")
    public List<Reservation> Reservations(){
        return reservationServiceImpl.getAllReservations();
    }

    @GetMapping("/Reservation/{reservationId}")
    public Reservation findByReservationId(@PathVariable int reservationId) throws Exception {
        return reservationServiceImpl.findByReservationId(reservationId);
    }

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation)throws Exception{
        Movie movie = reservation.getMovie();
        User registerUser =  reservation.getRegisterUser();
        return reservationServiceImpl.addReservation(reservation, movie, registerUser);
    }
}

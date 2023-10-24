package com.sda.MidProject.controller;

import com.sda.MidProject.entity.*;
import com.sda.MidProject.service.implementations.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @PostMapping("/addReservation/")
//    public Reservation addReservation(@RequestBody Reservation reservation)throws Exception{
//        Movie movie = reservation.getMovie();
//        RegisterUser registerUser = (RegisterUser) reservation.getRegisterUser();
//        return reservationServiceImpl.addReservation(reservation, movie, registerUser);
//    }
}

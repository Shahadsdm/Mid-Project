package com.sda.MidProject.controller;

import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.entity.Reservation;
import com.sda.MidProject.service.implementations.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationServiceImpl;

    @GetMapping("/Reservations")
    public List<Reservation> Reservations(){
        return reservationServiceImpl.getAllReservations();
    }
}

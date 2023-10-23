package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Reservation;
import com.sda.MidProject.repository.ReservationRepository;
import com.sda.MidProject.service.interfaces.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationServiceInterface {

    @Autowired
    private ReservationRepository reservationRepository;
    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}

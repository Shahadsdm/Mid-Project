package com.sda.MidProject.repository;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation,Integer> {
}

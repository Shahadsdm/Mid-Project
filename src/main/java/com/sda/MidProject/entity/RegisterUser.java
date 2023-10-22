package com.sda.MidProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity class for representing a RegisterUser in the database
 */
@Entity
/**
 * Using lombok annotations
 */
@Data

public class RegisterUser extends User {

    @OneToMany(mappedBy = "registerUserId")
    private List<Reservation> reservations;

    public RegisterUser() {
    }

    public RegisterUser(int userId, String name, String email, String password, String role, List<Reservation> reservations) {
        super(userId, name, email, password, "RegisterUser");
        this.reservations = reservations;
    }
}

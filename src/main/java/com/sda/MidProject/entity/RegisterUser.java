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
@NoArgsConstructor
public class RegisterUser extends User {


    public RegisterUser(int userId, String name, String email) {
        super(userId, name, email, "RegisterUser");
    }
}

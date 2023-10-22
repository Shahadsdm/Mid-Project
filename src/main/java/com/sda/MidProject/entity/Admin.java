package com.sda.MidProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entity class for representing an Admin in the database
 */
@Entity
/**
 * Using lombok annotations
 */
@Data
public class Admin extends User{

    @OneToMany(mappedBy = "admin")
    private List<Movie> managedMovies;

    public Admin() {
    }
    public Admin(int userId, String name, String email, String password, String role, List<Movie> managedMovies) {
        super(userId, name, email, password, "Admin");
        this.managedMovies = managedMovies;
    }
}

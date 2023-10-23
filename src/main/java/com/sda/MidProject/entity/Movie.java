package com.sda.MidProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private int movieId;

    private String title;

    private double duration;

    private double rating;

    @Enumerated(EnumType.STRING)
    private MovieCategory category;

//    @OneToMany(mappedBy = "movie")
//    private List<Reservation> reservedMovies;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;


}

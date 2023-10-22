package com.sda.MidProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entity class for representing an User in the database
 */
@Entity
/**
 * Using lombok annotations
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {

    /**
     * The primary key for the User table
     */
    @Id
    private int userId;

    /**
     * The name of the user
     */
    private String name;

    /**
     * The email of the user
     */
    private String email;

    /**
     * The password of the user
     */
    private String password;

    /**
     * The role of the user
     */
    private String role;

}

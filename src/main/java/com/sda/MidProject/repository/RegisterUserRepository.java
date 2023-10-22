package com.sda.MidProject.repository;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterUserRepository  extends JpaRepository<RegisterUser,Integer> {
}

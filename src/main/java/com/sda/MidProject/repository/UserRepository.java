package com.sda.MidProject.repository;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {
}

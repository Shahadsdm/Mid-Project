package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.service.implementations.RegisterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserServiceImpl registerUserServiceImpl;

    @GetMapping("/RegisterUsers")
    public List<RegisterUser> RegisterUsers(){
        return registerUserServiceImpl.getAllRegisterUsers();
    }
}

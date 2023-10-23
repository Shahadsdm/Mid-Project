package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.service.implementations.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @GetMapping("/Admins")
    public List<Admin> admins(){
        return adminServiceImpl.getAllAdmins();
    }
}

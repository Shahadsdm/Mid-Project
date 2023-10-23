package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.service.interfaces.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminServiceInterface {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }
}

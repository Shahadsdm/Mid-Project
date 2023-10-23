package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.repository.RegisterUserRepository;
import com.sda.MidProject.service.interfaces.RegisterUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterUserServiceImpl implements RegisterUserServiceInterface {

    @Autowired
    private RegisterUserRepository registerUserRepository;
    @Override
    public List<RegisterUser> getAllRegisterUsers() {
        return registerUserRepository.findAll();
    }
}

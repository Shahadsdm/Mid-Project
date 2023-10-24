package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.repository.RegisterUserRepository;
import com.sda.MidProject.service.interfaces.RegisterUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterUserServiceImpl implements RegisterUserServiceInterface {

    @Autowired
    private RegisterUserRepository registerUserRepository;
    @Override
    public List<RegisterUser> getAllRegisterUsers() {
        return registerUserRepository.findAll();
    }

    @Override
    public RegisterUser addRegisterUser(RegisterUser registerUser) throws Exception {
        if (registerUserRepository.existsById(registerUser.getUserId())) {
            throw new Exception("RegisterUser with ID " + registerUser.getUserId() + " already exists.");
        } else {
            return registerUserRepository.save(registerUser);
        }
    }

    @Override
    public RegisterUser findByRegisterUserId(int registerUserId) {
        Optional<RegisterUser> registerUserOptional = registerUserRepository.findById(registerUserId);
        if (registerUserOptional.isPresent()) {
            return registerUserOptional.get();
        } else {
            System.out.println("RegisterUser not found");
            return null;
        }
    }

    @Override
    public String deleteRegisterUser(int registerUserId) {
        if (registerUserRepository.existsById(registerUserId)){
            registerUserRepository.deleteById(registerUserId);
            return "RegisterUser deleted Successfully";
        }else {
            return "RegisterUser not found";
        }
    }

    @Override
    public String updateRegisterUser(int registerUserId, RegisterUser registerUser) {
        Optional<RegisterUser> registerUserOptional = registerUserRepository.findById(registerUserId);
        if (registerUserOptional.isPresent()) {
            registerUser.setName(registerUser.getName());
            registerUser.setEmail(registerUser.getEmail());
            registerUserRepository.save(registerUser);
            return "RegisterUser updated";
        } else {
            return "RegisterUser not found";
        }
    }


}

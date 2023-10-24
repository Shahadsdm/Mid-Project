package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;

import java.util.List;

public interface RegisterUserServiceInterface {

    List<RegisterUser> getAllRegisterUsers();

    RegisterUser addRegisterUser(RegisterUser registerUser) throws Exception;

    RegisterUser findByRegisterUserId(int registerUserId) throws Exception;

    String deleteRegisterUser(int registerUserId);

    String updateRegisterUser(int registerUserId, RegisterUser registerUser);
}

package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.dto.JwtAuthenticationResponse;
import com.sda.MidProject.dto.SignInRequest;
import com.sda.MidProject.dto.SignUpRequest;
import com.sda.MidProject.entity.User;

public interface AuthenticationService {

     User signup(SignUpRequest signUpRequest);

    public JwtAuthenticationResponse signin(SignInRequest signInRequest);


    }

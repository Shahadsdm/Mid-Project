package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JWTService {

     String extractUserName(String token);

     String generateToken(UserDetails userDetails);

     boolean isTokenValid(String token, UserDetails userDetails);

    public String generateRefreshToken(HashMap<String, Object> objectObjectHashMap, UserDetails userDetails);
}

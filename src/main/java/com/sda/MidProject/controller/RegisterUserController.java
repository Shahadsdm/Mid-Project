package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.entity.RegisterUser;
import com.sda.MidProject.service.implementations.RegisterUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterUserController {

    @Autowired
    private RegisterUserServiceImpl registerUserServiceImpl;

    @GetMapping("/RegisterUsers")
    public List<RegisterUser> RegisterUsers(){
        return registerUserServiceImpl.getAllRegisterUsers();
    }

    @GetMapping("/RegisterUser/{registerUserId}")
    public RegisterUser findByRegisterUserId(@PathVariable int registerUserId) throws Exception {
        return registerUserServiceImpl.findByRegisterUserId(registerUserId);
    }

    @PostMapping("/addRegisterUser")
    public RegisterUser addRegisterUser(@RequestBody RegisterUser registerUser) throws Exception{
        return registerUserServiceImpl.addRegisterUser(registerUser);
    }

    @DeleteMapping("/deleteRegisterUser/{registerUserId}")
    public ResponseEntity<String> deleteRegisterUser(@PathVariable int registerUserId){
        try{
            String message = registerUserServiceImpl.deleteRegisterUser(registerUserId);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            String eerMessage = "RegisterUser not deleted successfully" + e.getMessage();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eerMessage);
        }
    }

    @PutMapping("/updateRegisterUser/{registerUserId}")
    public ResponseEntity<String> updateRegisterUser(@PathVariable int registerUserId,@RequestBody RegisterUser registerUser){
        try{
            registerUserServiceImpl.updateRegisterUser(registerUserId,registerUser);
            String message = "RegisterUser updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            String eerMessage = "RegisterUser not updated successfully" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eerMessage);
        }
    }

}

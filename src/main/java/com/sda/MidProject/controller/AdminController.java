package com.sda.MidProject.controller;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.service.implementations.AdminServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;


    @GetMapping("/Admins")
    public List<Admin> admins(){
        return adminServiceImpl.getAllAdmins();
    }

    @GetMapping("/Admin/{adminId}")
    public Admin findByAdminId(@PathVariable int adminId) throws Exception {
        return adminServiceImpl.findByAdminId(adminId);
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) throws Exception{
        return adminServiceImpl.addAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int adminId){
        try{
            String message = adminServiceImpl.deleteAdmin(adminId);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }catch (Exception e){
            String eerMessage = "Admin not deleted successfully" + e.getMessage();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eerMessage);
        }
    }

}

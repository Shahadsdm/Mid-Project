package com.sda.MidProject.service.implementations;

import com.sda.MidProject.entity.Admin;
import com.sda.MidProject.repository.AdminRepository;
import com.sda.MidProject.service.interfaces.AdminServiceInterface;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AdminServiceImpl implements AdminServiceInterface {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addAdmin(Admin admin) throws Exception {
        if (adminRepository.existsById(admin.getUserId())) {
            throw new Exception("Admin with ID " + admin.getUserId() + " already exists.");
        } else {
            return adminRepository.save(admin);
        }    }

    @Override
    public Admin findByAdminId(int adminId) throws Exception {
        Optional<Admin> adminOptional = adminRepository.findById(adminId);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        } else {
            throw new Exception("Admin not found");
        }
    }

    @Override
    public String deleteAdmin(int adminId) {
        if (adminRepository.existsById(adminId)){
            adminRepository.deleteById(adminId);
            return "Admin deleted Successfully";
        }else {
            return "Admin not found";
        }
    }
}

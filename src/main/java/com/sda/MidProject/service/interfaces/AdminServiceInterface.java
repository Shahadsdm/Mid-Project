package com.sda.MidProject.service.interfaces;

import com.sda.MidProject.entity.Admin;

import java.util.List;

public interface AdminServiceInterface {

    List<Admin> getAllAdmins();

    Admin addAdmin(Admin admin) throws Exception;

    Admin findByAdminId(int adminId);

    String deleteAdmin(int adminId);
}

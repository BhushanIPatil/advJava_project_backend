package com.cdac.controller;

import com.cdac.dto.LoginStatus;

import com.cdac.dto.RegistrationStatus;
import com.cdac.entity.Admin;
import com.cdac.exception.AdminServiceException;
import com.cdac.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/login")
    public LoginStatus login(@RequestBody Admin admin) {
        try {
            
            Admin authenticatedAdmin = adminService.login(admin.getEmail(), admin.getPassword());

            LoginStatus status = new LoginStatus();
            status.setStatus(true);
            status.setStatusMessage("Login successful!");
            status.setUserId(authenticatedAdmin.getId());
            return status;
        } catch (AdminServiceException e) {
            LoginStatus status = new LoginStatus();
            status.setStatus(false);
            status.setStatusMessage(e.getMessage());
            return status;
        }
    }
}









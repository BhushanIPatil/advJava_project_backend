package com.cdac.controller;

import com.cdac.dto.LoginStatus;

import com.cdac.dto.RegistrationStatus;
import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;
import com.cdac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegistrationStatus register(@RequestBody User user) {
        try {
            int id = userService.register(user);

            RegistrationStatus status = new RegistrationStatus();
            status.setStatus(true);
            status.setStatusMessage("Customer registered successfully!");
            status.setUserId(id);
            return status;
        } catch (UserServiceException e) {
            RegistrationStatus status = new RegistrationStatus();
            status.setStatus(false);
            status.setStatusMessage(e.getMessage());
            return status;
        }
    }

    @PostMapping("/login")
    public LoginStatus login(@RequestBody User user) {
        try {
            
            User authenticatedUser = userService.login(user.getEmail(), user.getPassword());

            LoginStatus status = new LoginStatus();
            status.setStatus(true);
            status.setStatusMessage("Login successful!");
            status.setUserId(authenticatedUser.getId());
            return status;
        } catch (UserServiceException e) {
            LoginStatus status = new LoginStatus();
            status.setStatus(false);
            status.setStatusMessage(e.getMessage());
            return status;
        }
    }
}









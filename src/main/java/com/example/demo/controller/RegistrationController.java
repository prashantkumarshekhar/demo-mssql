package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;

@RestController
@RequestMapping("/user")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return registrationService.addUser(user);
    }

}

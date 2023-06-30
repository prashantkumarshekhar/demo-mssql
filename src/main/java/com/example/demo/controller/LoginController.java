package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
    // Check User is registered or not
    @GetMapping("/isValidUser")
    public  Boolean isValidUser(@RequestParam String username, @RequestParam String password) {
        return  loginService.isValidUser(username,password);
    }


}

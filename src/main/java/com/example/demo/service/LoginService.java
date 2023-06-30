package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
    private UserRepository userRepository;
	
	public Boolean isValidUser(String username,String password) {
        User dbUser=userRepository.findByUsername(username);
        if(password.equals(dbUser.getPassword()))
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

}

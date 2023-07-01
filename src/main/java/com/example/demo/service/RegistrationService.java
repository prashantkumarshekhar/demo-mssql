package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
    private UserRepository userRepository;
	
	public User addUser(User user) {
		
		BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
		String encryptedPassword=bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPassword);//save encrypted password rather than plain text
		
		//set default role
		user.setRole("user");
		
        return userRepository.save(user);
    }

}

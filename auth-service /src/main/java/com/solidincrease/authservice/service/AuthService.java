package com.solidincrease.authservice.service;


import com.solidincrease.authservice.entity.UserCredential;

import com.solidincrease.authservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {


    @Autowired
    private UserCredentialRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;



    public String saveUser(UserCredential credential) {

       if(repository.existsByName(credential.getName()))
       {
           return  "email already exists";
       }else {
           credential.setPassword(passwordEncoder.encode(credential.getPassword()));
           repository.save(credential);
           return "user added to the system";
       }

    }

    public Optional<UserCredential> getUser(String username){

        return repository.findByName(username);
    }

    public String  generateToken(Optional<UserCredential> user) {
       String userName= user.get().getName();
       String id = String.valueOf(user.get().getId());
        return jwtService.generateToken(userName,id);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}

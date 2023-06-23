package com.solidincrease.authservice.controller;

import com.solidincrease.authservice.dto.AuthRequest;
import com.solidincrease.authservice.dto.HeaderDto;
import com.solidincrease.authservice.dto.LoginResponse;
import com.solidincrease.authservice.entity.Token;
import com.solidincrease.authservice.entity.UserCredential;
import com.solidincrease.authservice.repository.TokenRepository;
import com.solidincrease.authservice.service.AuthService;
import com.solidincrease.authservice.service.JwtService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@AllArgsConstructor
@NoArgsConstructor
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenRepository tokenRepository;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public LoginResponse getToken(@RequestBody AuthRequest authRequest) {


        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

        if (authenticate.isAuthenticated()) {
         Optional<UserCredential> user =   service.getUser(authRequest.getUsername());
            LoginResponse loginResponse = new LoginResponse();

             String token =  service.generateToken(user);
             Token saveToken = Token.builder()
                     .token(token)
                     .build();

             tokenRepository.save(saveToken);

            loginResponse.setToken(token);
            loginResponse.setId(Integer.toString(user.get().getId()));

            loginResponse.setUserName(user.get().getName());
            loginResponse.setLoggedIn(true);
            return loginResponse;
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {

       if(!tokenRepository.existsByToken(token)) return "Token not valid";
        service.validateToken(token);
        return "Token is valid";
    }



    @GetMapping("/tokval")
    public HeaderDto decompileToken(@RequestHeader("Authorization") String token) {
         String cheekToken = token.replace("Bearer ", "");
         if(!tokenRepository.existsByToken(cheekToken)) throw new RuntimeException("Token dose not exisst ")                 ;
    return jwtService.headerDeconstruct(token);
    }


    @PostMapping("/logout")
    public String logoutToken(@RequestHeader("Authorization") String token) {

       return jwtService.logoutToken(token);

    }
}


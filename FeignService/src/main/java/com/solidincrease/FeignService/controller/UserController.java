package com.solidincrease.FeignService.controller;

import com.soldincrease.FeignServices.dto.Responce;
import com.soldincrease.FeignServices.dto.UserRegistrationRequest;
import com.soldincrease.FeignServices.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {


    private static  final Logger LOGGER
            = LoggerFactory.getLogger(UserController.class);
    private  final UserService userService;
    @PostMapping
    public Responce registerUser(@RequestBody UserRegistrationRequest userRegister){
        LOGGER.info("User add: {}", userRegister);
        return userService.registerCustomer(userRegister).orElse(null);
    }




}

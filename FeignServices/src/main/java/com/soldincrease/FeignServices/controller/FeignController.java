package com.soldincrease.FeignServices.controller;

import com.soldincrease.FeignServices.dto.HeaderDto;
import com.soldincrease.FeignServices.service.FeignService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;




@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class FeignController {

    private static  final Logger LOGGER
            = LoggerFactory.getLogger(FeignController.class);
    private  final FeignService userService;



    @GetMapping
    public HeaderDto headerDeconstruct(@RequestHeader("Authorization") String token) {
       return  userService.headerDeconstruct(token);
    }




}

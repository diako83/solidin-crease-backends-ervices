package com.soldincrease.CloudeGateway.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class FallbackController {

    //Cardio Services
    @GetMapping("/cardioServiceFallBack")
    public String cardioServiceFallback() {
        return "Cardio Service is down!";
    }

    @PostMapping("/cardioServiceFallBack")
    public String postCardioServiceFallback() {
        return "Cardio Service is down!";
    }

    @PutMapping("/cardioServiceFallBack")
    public String putCardioServiceFallback() {
        return "Cardio Service is down!";
    }

    @DeleteMapping("/cardioServiceFallBack")
    public String deleteCardioServiceFallback() {
        return "Cardio Service is down!";
    }

    //Gym Services
    @GetMapping("/gymServiceFallBack")
    public String gymServiceFallback() {
        return "Gym Service is down!";
    }

    @PostMapping("/gymServiceFallBack")
    public String postGymServiceFallback() {
        return "Gym Service is down!";
    }

    @PutMapping ("/gymServiceFallBack")
    public String putGymServiceFallback() {
        return "Gym Service is down!";
    }

    @DeleteMapping("/gymServiceFallBack")
    public String deleteGymServiceFallback() {
        return "Gym Service is down!";
    }

    //Hiit services
    @GetMapping("/hiitServiceFallBack")
    public String hiitServiceFallback() {
        return "Hiit Service is down!";
    }

    @PostMapping("/hiitServiceFallBack")
    public String postHiitServiceFallback() {
        return "Hiit Service is down!";
    }

    @PutMapping("/hiitServiceFallBack")
    public String putHiitServiceFallback() {
        return "Hiit Service is down!";
    }

    @DeleteMapping("/hiitServiceFallBack")
    public String deleteHiitServiceFallback() {
        return "Hiit Service is down!";
    }

    //Kettlebell services
    @GetMapping("/kbServiceFallBack")
    public String kbServiceFallback() {
        return "Kettlebell Service is down!";
    }

    @PostMapping("/kbServiceFallBack")
    public String postKbServiceFallback() {
        return "Kettlebell Service is down!";
    }

    @PutMapping("/kbServiceFallBack")
    public String putKbServiceFallback() {
        return "Kettlebell Service is down!";
    }

    @DeleteMapping("/kbServiceFallBack")
    public String deleteKbServiceFallback() {
        return "Kettlebell Service is down!";
    }


    //Yoga services
    @GetMapping("/yogaServiceFallBack")
    public String yogaServiceFallback() {
        return "Yoga Service is down!";
    }

    @PutMapping("/yogaServiceFallBack")
    public String putYgaServiceFallback() {
        return "Yoga Service is down!";
    }

    @PostMapping("/yogaServiceFallBack")
    public String postYogaServiceFallback() {
        return "Yoga Service is down!";
    }

    @DeleteMapping("/yogaServiceFallBack")
    public String deleteYogaServiceFallback() {
        return "Yoga Service is down!";
    }


    //UserServices
    @GetMapping("/userServiceFallBack")
    public String userServiceFallback() {
        return "User Service is down!";
    }

    @PostMapping("/userServiceFallBack")
    public String postUserServiceFallback() {
        return "User Service is down!";
    }

    @PutMapping ("/userServiceFallBack")
    public String putUserServiceFallback() {
        return "User Service is down!";
    }

    @DeleteMapping("/userServiceFallBack")
    public String deleteUserServiceFallback() {
        return "User Service is down!";
    }
}

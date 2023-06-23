package com.soldincrease.GymServices.controller;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.GymServices.dto.RequestGymWorkout;

import com.soldincrease.GymServices.service.GymServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/gym")
public class GymController {

    private final GymServices gymServices;

    @PostMapping
    public ResponseModel postWorkout(@RequestBody RequestGymWorkout requestGymWorkout){
        return gymServices.postGymWorkout(requestGymWorkout);
    }

    @GetMapping("/all/{id}")
    public ResponseModel getAllGymWorkouts(@PathVariable String id){
        return gymServices.getAllGymWorkouts(id);
    }

    @GetMapping("/single/{id}")
    public ResponseModel getSingleGymWorkouts(@PathVariable String id){
        return gymServices.getSingleGymWorkouts(id);
    }

    @DeleteMapping("/single/delete/{id}")
    public ResponseModel getDeleteGymWorkouts(@PathVariable String id){
        return gymServices.getDeleteGymWorkouts(id);
    }
}


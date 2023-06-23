package com.soldincrease.SharedServices.controller;

import com.soldincrease.SharedServices.dto.GymDtos.RequestGymWorkout;
import com.soldincrease.SharedServices.entity.GymEntitys.GymWorkoutEntity;
import com.soldincrease.SharedServices.service.GymServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v2/gym")
public class GymController {

    private final GymServices gymServices;

    @PostMapping
    public GymWorkoutEntity postWorkout(@RequestBody RequestGymWorkout requestGymWorkout){


        return gymServices.postGymWorkout(requestGymWorkout);
    }


    @GetMapping
    public List<GymWorkoutEntity> getAll(){
        return gymServices.getAll().collect(Collectors.toList());

    }
}

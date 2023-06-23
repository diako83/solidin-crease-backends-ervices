package com.soldincrease.DefaultDataServices.controller;

import com.soldincrease.DefaultDataServices.dto.GymDtos.RequestGym;
import com.soldincrease.DefaultDataServices.entity.GymEntity;
import com.soldincrease.DefaultDataServices.service.GymServices;
import com.soldincrease.DefaultDataServices.utils.GymEntityToRequestGym;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v3/gym")
public class GymController {

    private final GymServices gymServices;



    @PostMapping
    GymEntity setCardioExercises(@RequestBody RequestGym requestGym){

        return gymServices.setGymExercises(requestGym);
    }


    @GetMapping Stream<RequestGym> getCardioExercises(){

        return gymServices.getGymExercises().map(GymEntityToRequestGym::gymEntityToRequestGym);
    }




}


package com.soldincrease.SharedServices.controller;


import com.soldincrease.SharedServices.dto.CardioDto.RequestCardioWorkout;
import com.soldincrease.SharedServices.service.CardioServices;
import com.soldincrease.SharedServices.utils.CardioUtil.EntityToCardioWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v2/cardio")
public class CardioController {


    private final CardioServices cardioServices;

    @PostMapping
    public RequestCardioWorkout postWorkout(@RequestBody RequestCardioWorkout requestCardioWorkout){
      return EntityToCardioWorkoutDto.entityToCardioWorkoutDto(cardioServices.postCardioWorkout(requestCardioWorkout));

    }


    @GetMapping
    public List<RequestCardioWorkout> getAllCardio(){
        return cardioServices.getAllCardio().map(EntityToCardioWorkoutDto ::entityToCardioWorkoutDto).collect(Collectors.toList());

    }
}

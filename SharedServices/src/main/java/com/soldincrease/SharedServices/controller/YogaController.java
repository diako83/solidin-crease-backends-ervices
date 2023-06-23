package com.soldincrease.SharedServices.controller;


import com.soldincrease.SharedServices.dto.YogaDto.RequestYogaWorkout;
import com.soldincrease.SharedServices.service.YogaServices;
import com.soldincrease.SharedServices.utils.YogaUtils.EntityToWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v2/yoga")
public class YogaController {


    private final YogaServices yogaServices;

    @PostMapping
    public RequestYogaWorkout postWorkout(@RequestBody RequestYogaWorkout requestYogaWorkout){
     return    EntityToWorkoutDto.entityToWorkoutDto( yogaServices.postWorkout(requestYogaWorkout));

    }

    @GetMapping
    public List<RequestYogaWorkout> getAllYoga(){
        return yogaServices.getAllYoga().map(EntityToWorkoutDto::entityToWorkoutDto).collect(Collectors.toList());

    }

}

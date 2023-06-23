package com.soldincrease.SharedServices.controller;


import com.soldincrease.SharedServices.dto.KbDto.RequestKbWorkout;
import com.soldincrease.SharedServices.service.KbServices;
import com.soldincrease.SharedServices.utils.KbUtils.EntityToKbWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v2/kb")
public class KbController {


    private final KbServices kbServices;

    @PostMapping
    public RequestKbWorkout postWorkout(@RequestBody RequestKbWorkout requestKbWorkout){
     return    EntityToKbWorkoutDto.entityToKbWorkoutDto( kbServices.postKbWorkout(requestKbWorkout));
    }


    @GetMapping
    public List<RequestKbWorkout> getAll(){
        return kbServices.getAll().map(EntityToKbWorkoutDto::entityToKbWorkoutDto).collect(Collectors.toList());

    }
}

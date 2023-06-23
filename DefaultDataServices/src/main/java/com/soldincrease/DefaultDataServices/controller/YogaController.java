package com.soldincrease.DefaultDataServices.controller;

import com.soldincrease.DefaultDataServices.dto.YogaDtos.RequestYoga;
import com.soldincrease.DefaultDataServices.entity.YogaEntity;
import com.soldincrease.DefaultDataServices.service.YogaService;
import com.soldincrease.DefaultDataServices.utils.YogaEntityToRequestYoga;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v3/yoga")
public class YogaController {


 private final YogaService yogaService;

    @PostMapping
    public YogaEntity setCardioExercises(@RequestBody RequestYoga requestYoga){

        return yogaService.setYogaExercises(requestYoga);
    }


    @GetMapping
    public Stream<RequestYoga> getCardioExercises(){

        return yogaService.getYogaExercises().map(YogaEntityToRequestYoga::yogaEntityToRequestYoga);
    }

}


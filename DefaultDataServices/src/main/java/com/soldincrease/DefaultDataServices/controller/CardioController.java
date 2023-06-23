package com.soldincrease.DefaultDataServices.controller;

import com.soldincrease.DefaultDataServices.dto.CardioDtos.RequestCardio;
import com.soldincrease.DefaultDataServices.service.CardioServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v3/cardio")
public class CardioController {
    private final CardioServices cardioServices;


    @PostMapping
    public String setCardioExercises(@RequestBody RequestCardio exercise){
        System.out.println(exercise);
        return cardioServices.setCardioExercises(exercise);
    }

    @GetMapping
    public Stream<String> getLisOfCardioExercises(){
        return cardioServices.getLisOfCardioExercises();
    }
}

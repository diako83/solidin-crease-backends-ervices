package com.soldincrease.DefaultDataServices.controller;

import com.soldincrease.DefaultDataServices.dto.KettlebellDto.RequestKettlebell;
import com.soldincrease.DefaultDataServices.entity.KettlebellEntity;
import com.soldincrease.DefaultDataServices.service.KettlebellService;
import com.soldincrease.DefaultDataServices.utils.KettlebellEntityToRequestKettlebell;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v3/kettlebell")
public class KettlebellController {

    private final KettlebellService kettlebellService;

    @PostMapping
    public KettlebellEntity setCardioExercises(@RequestBody RequestKettlebell requestKettlebell){

        return kettlebellService.setKettlebellExercises(requestKettlebell);
    }


    @GetMapping
    public Stream<RequestKettlebell> getCardioExercises(){

        return kettlebellService.getKettlebellExercises().map(KettlebellEntityToRequestKettlebell::kettlebellEntityToRequestKettlebell);
    }


}

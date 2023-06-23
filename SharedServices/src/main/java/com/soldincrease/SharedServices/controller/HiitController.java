package com.soldincrease.SharedServices.controller;


import com.soldincrease.SharedServices.dto.HiitDto.RequestHiitWorkout;
import com.soldincrease.SharedServices.service.HiitServices;
import com.soldincrease.SharedServices.utils.HiitUtil.EntityToHiitWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v2/hiit")
public class HiitController {


    private final HiitServices hiitServices;

    @PostMapping
    public RequestHiitWorkout postWorkout(@RequestBody RequestHiitWorkout requestHiitWorkout){
      return EntityToHiitWorkoutDto.entityToHiitWorkoutDto(hiitServices.postHiitWorkout(requestHiitWorkout));
    }

    @GetMapping
    public List<RequestHiitWorkout > getAll(){
       // return hiitServices.getAll().map(EntityToHiitWorkoutDto::entityToHiitWorkoutDto).collect(Collectors.toList());
        return hiitServices.getAll()
                .map(EntityToHiitWorkoutDto::entityToHiitWorkoutDto).collect(Collectors.toList());

    }
}

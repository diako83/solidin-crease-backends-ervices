package com.soldincrease.HiitServices.controller;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.HiitServices.dto.RequestHiitWorkout;
import com.soldincrease.HiitServices.service.HiitServices;
import com.soldincrease.HiitServices.utils.EntityToHiitWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/hiit")
public class HiitController {


    private final HiitServices hiitServices;

    @PostMapping
    public ResponseModel postWorkout(@RequestBody RequestHiitWorkout requestHiitWorkout){
        RequestHiitWorkout savedEntity =      EntityToHiitWorkoutDto.entityToHiitWorkoutDto(hiitServices.postHiitWorkout(requestHiitWorkout));

        ResponseModel<Object> responseModel = new ResponseModel<>();
        if (savedEntity!= null) {
            responseModel.setData(savedEntity);
            responseModel.setStatus(200);
        } else {
            responseModel.setStatus(403);
        }
        return responseModel;

    }

    @GetMapping("/all/{id}")
    public ResponseModel getAllHiitWorkouts(@PathVariable String id){
        return hiitServices.getAllHiitWorkouts(id);
    }

    @GetMapping("/single/{id}")
    public ResponseModel getSingleHiitWorkouts(@PathVariable String id){
        return hiitServices.getSingleHiitWorkouts(id);
    }

    @DeleteMapping("/single/delete/{id}")
    public ResponseModel getDeleteHiitWorkouts(@PathVariable String id){
        return hiitServices.deleteHiitWorkouts(id);
    }
}

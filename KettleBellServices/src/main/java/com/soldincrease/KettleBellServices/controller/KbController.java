package com.soldincrease.KettleBellServices.controller;


import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.KettleBellServices.dto.RequestKbWorkout;
import com.soldincrease.KettleBellServices.service.KbServices;
import com.soldincrease.KettleBellServices.utils.EntityToKbWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/kb")

public class KbController {


    private final KbServices kbServices;

    @PostMapping
    public ResponseModel postWorkout(@RequestBody RequestKbWorkout requestKbWorkout){
      RequestKbWorkout savedEntity=  EntityToKbWorkoutDto.entityToKbWorkoutDto(kbServices.postKbWorkout(requestKbWorkout));

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
    public ResponseModel getAllKbbWorkouts(@PathVariable String id){
        return kbServices.getAllKbWorkouts(id);
    }
    @GetMapping("/single/{id}")
    public ResponseModel getSingleKbWorkouts(@PathVariable String id){
        return kbServices.getSingleKbWorkouts(id);
    }

    @DeleteMapping("/single/delete/{id}")
    public ResponseModel deleteKbWorkouts(@PathVariable String id){
        return kbServices.deleteKbWorkout(id);
    }
}

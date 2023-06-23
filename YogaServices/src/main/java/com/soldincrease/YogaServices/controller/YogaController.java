package com.soldincrease.YogaServices.controller;


import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.YogaServices.dto.RequestYogaWorkout;
import com.soldincrease.YogaServices.service.YogaServices;
import com.soldincrease.YogaServices.utils.EntityToWorkoutDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/yoga")
public class YogaController {


    private final YogaServices yogaServices;

    @PostMapping
    public ResponseModel postWorkout(@RequestBody RequestYogaWorkout requestYogaWorkout){
     RequestYogaWorkout savedEntity =   EntityToWorkoutDto.entityToWorkoutDto( yogaServices.postWorkout(requestYogaWorkout));

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
    public ResponseModel getAllKbioWorkouts(@PathVariable String id){
        return yogaServices.getAllYogaWorkouts(id);
    }
    @GetMapping("/single/{id}")
    public ResponseModel getSingleKbWorkouts(@PathVariable String id){
        return yogaServices.getSingleYogaWorkouts(id);
    }

    @DeleteMapping("/single/delete/{id}")
    public ResponseModel deleteKbWorkouts(@PathVariable String id){
        return yogaServices.deleteYogaWorkout(id);
    }
}

package com.soldincrease.CardioServices.controller;



import com.soldincrease.CardioServices.dto.RequestCardioWorkout;
import com.soldincrease.CardioServices.entity.CardioWorkoutEntity;
import com.soldincrease.CardioServices.service.CardioServices;
import com.soldincrease.CardioServices.util.EntityToCardioWorkoutDto;
import com.soldincrease.FeignServices.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor

@RequestMapping("api/v1/cardio")
public class CardioController {


    private final CardioServices cardioServices;

    @PostMapping
    public ResponseModel postWorkout(@RequestBody RequestCardioWorkout requestCardioWorkout){


        RequestCardioWorkout savedEntity =  EntityToCardioWorkoutDto.entityToCardioWorkoutDto(cardioServices.postCardioWorkout(requestCardioWorkout));
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
    public ResponseModel getAllCardioWorkouts(@PathVariable String id){
        return cardioServices.getAllCardioWorkouts(id);
    }
    @GetMapping("/single/{id}")
    public ResponseModel getSingleCArdioWorkouts(@PathVariable String id){
        return cardioServices.getSingleCardioWorkouts(id);
    }

    @DeleteMapping("/single/delete/{id}")
    public ResponseModel deleteCardioWorkouts(@PathVariable String id){
        return cardioServices.deleteCardioWorkouts(id);
    }
}

package com.soldincrease.GymServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.GymServices.dto.RequestGymWorkout;


public interface IGymServices {
    ResponseModel postGymWorkout(RequestGymWorkout requestGymWorkout);
    ResponseModel getAllGymWorkouts(String userId );
    ResponseModel getSingleGymWorkouts(String id);

    ResponseModel getDeleteGymWorkouts(String id);
}

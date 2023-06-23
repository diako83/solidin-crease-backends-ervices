package com.soldincrease.YogaServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.YogaServices.dto.RequestYogaWorkout;
import com.soldincrease.YogaServices.entity.YogaWorkoutEntity;



public interface IYogaServices {
    YogaWorkoutEntity postWorkout(RequestYogaWorkout requestYogaWorkout);
    ResponseModel getAllYogaWorkouts(String userId );
    ResponseModel getSingleYogaWorkouts(String id);

    ResponseModel deleteYogaWorkout(String id);

}

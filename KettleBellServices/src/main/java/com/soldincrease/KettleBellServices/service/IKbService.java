package com.soldincrease.KettleBellServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.KettleBellServices.dto.RequestKbWorkout;
import com.soldincrease.KettleBellServices.entity.KbWorkoutEntity;

public interface IKbService {
    KbWorkoutEntity postKbWorkout(RequestKbWorkout requestKbWorkout);

    ResponseModel getAllKbWorkouts(String userId );
    ResponseModel getSingleKbWorkouts(String id);

    ResponseModel deleteKbWorkout(String id);
}

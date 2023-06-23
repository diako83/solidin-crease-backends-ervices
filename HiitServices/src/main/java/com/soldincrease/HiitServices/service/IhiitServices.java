package com.soldincrease.HiitServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.HiitServices.dto.RequestHiitWorkout;
import com.soldincrease.HiitServices.entity.HiitWorkoutEntity;

public interface IhiitServices {
    HiitWorkoutEntity postHiitWorkout(RequestHiitWorkout requestHiitWorkout);

    ResponseModel getAllHiitWorkouts(String userId );
    ResponseModel getSingleHiitWorkouts(String id);

    ResponseModel deleteHiitWorkouts(String id);

}

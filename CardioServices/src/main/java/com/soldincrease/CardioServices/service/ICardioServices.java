package com.soldincrease.CardioServices.service;

import com.soldincrease.CardioServices.dto.RequestCardioWorkout;
import com.soldincrease.CardioServices.entity.CardioWorkoutEntity;
import com.soldincrease.FeignServices.model.ResponseModel;

import java.util.stream.Stream;

public interface ICardioServices {
    CardioWorkoutEntity postCardioWorkout(RequestCardioWorkout requestCardioWorkout);
    Stream<CardioWorkoutEntity> getAllCardio();

    ResponseModel getAllCardioWorkouts(String userId );
    ResponseModel getSingleCardioWorkouts(String id);

    ResponseModel deleteCardioWorkouts(String id);
}

package com.soldincrease.SharedServices.interfaces;

import com.soldincrease.SharedServices.dto.CardioDto.RequestCardioWorkout;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioWorkoutEntity;

import java.util.stream.Stream;

public interface ICardioServices {
    CardioWorkoutEntity postCardioWorkout(RequestCardioWorkout requestCardioWorkout);
    public Stream<CardioWorkoutEntity> getAllCardio();
}

package com.soldincrease.SharedServices.interfaces;

import com.soldincrease.SharedServices.dto.GymDtos.RequestGymWorkout;
import com.soldincrease.SharedServices.entity.GymEntitys.GymWorkoutEntity;

import java.util.stream.Stream;

public interface IGymServices {
    GymWorkoutEntity postGymWorkout(RequestGymWorkout requestGymWorkout);

    Stream<GymWorkoutEntity > getAll();
}

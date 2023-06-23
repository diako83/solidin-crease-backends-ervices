package com.soldincrease.SharedServices.interfaces;

import com.soldincrease.SharedServices.dto.YogaDto.RequestYogaWorkout;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaWorkoutEntity;

import java.util.stream.Stream;

public interface IYogaServices {
    YogaWorkoutEntity postWorkout(RequestYogaWorkout requestYogaWorkout);
    Stream<YogaWorkoutEntity> getAllYoga();
}

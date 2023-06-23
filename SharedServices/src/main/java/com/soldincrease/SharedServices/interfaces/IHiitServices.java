package com.soldincrease.SharedServices.interfaces;

import com.soldincrease.SharedServices.dto.HiitDto.RequestHiitWorkout;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitWorkoutEntity;

import java.util.stream.Stream;

public interface IHiitServices {
    HiitWorkoutEntity postHiitWorkout(RequestHiitWorkout requestHiitWorkout);
    Stream<HiitWorkoutEntity> getAll();
}

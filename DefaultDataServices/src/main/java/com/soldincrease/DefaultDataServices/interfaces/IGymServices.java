package com.soldincrease.DefaultDataServices.interfaces;

import com.soldincrease.DefaultDataServices.dto.GymDtos.RequestGym;
import com.soldincrease.DefaultDataServices.entity.GymEntity;

import java.util.stream.Stream;

public interface IGymServices {
    GymEntity setGymExercises(RequestGym gymEntity);

    Stream<GymEntity> getGymExercises();
}

package com.soldincrease.DefaultDataServices.interfaces;

import com.soldincrease.DefaultDataServices.dto.YogaDtos.RequestYoga;
import com.soldincrease.DefaultDataServices.entity.YogaEntity;

import java.util.stream.Stream;

public interface IYogaServices {
    YogaEntity setYogaExercises(RequestYoga requestYoga);
    Stream<YogaEntity> getYogaExercises();
}

package com.soldincrease.SharedServices.interfaces;

import com.soldincrease.SharedServices.dto.KbDto.RequestKbWorkout;
import com.soldincrease.SharedServices.entity.KbEntitys.KbWorkoutEntity;

import java.util.stream.Stream;

public interface IKbServices {
    KbWorkoutEntity postKbWorkout(RequestKbWorkout requestKbWorkout);
    Stream<KbWorkoutEntity> getAll();
}

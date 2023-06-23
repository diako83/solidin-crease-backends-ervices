package com.soldincrease.KettleBellServices.utils;

import com.soldincrease.KettleBellServices.dto.KbMovementDto;
import com.soldincrease.KettleBellServices.entity.KbMovementEntity;


public class EntityToKbMovementDto {

    public static KbMovementDto entityToKbMovementDto(KbMovementEntity movement){

        return KbMovementDto.builder()
                .id("")
                .name(movement.name)
                .sets(movement.sets)
                .reps(movement.reps)
                .weight(movement.weight)
                .timer(EntityToTimerDto.entityToTimerDto(movement.timer))
                .distance( EntityToDistanceDto.entityToDistanceDto(movement.distance))
                .build();

    }
}

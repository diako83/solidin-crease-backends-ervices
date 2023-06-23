package com.soldincrease.HiitServices.utils;


import com.soldincrease.HiitServices.dto.HiitMovementDto;
import com.soldincrease.HiitServices.entity.HiitMovementEntity;

public class EntityToKbMovementDto {

    public static HiitMovementDto entityToHiitMovementDto(HiitMovementEntity movement){

        return HiitMovementDto.builder()
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

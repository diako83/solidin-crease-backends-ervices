package com.soldincrease.YogaServices.utils;


import com.soldincrease.YogaServices.dto.YogaMovementDto;
import com.soldincrease.YogaServices.entity.YogaMovementEntity;

public class EntityToYogaMovementDto {

    public static YogaMovementDto entityToKbMovementDto(YogaMovementEntity movement){

        return YogaMovementDto.builder()
                .id("")
                .name(movement.name)
                .sets(movement.sets)
                .reps(movement.reps)

                .timer(EntityToTimerDto.entityToTimerDto(movement.timer))

                .build();

    }
}

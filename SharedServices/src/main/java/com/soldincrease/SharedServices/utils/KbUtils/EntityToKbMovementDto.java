package com.soldincrease.SharedServices.utils.KbUtils;


import com.soldincrease.SharedServices.dto.KbDto.KbMovementDto;
import com.soldincrease.SharedServices.entity.KbEntitys.KbMovementEntity;

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

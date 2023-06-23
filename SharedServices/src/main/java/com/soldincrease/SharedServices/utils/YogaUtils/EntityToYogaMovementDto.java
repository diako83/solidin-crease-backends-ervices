package com.soldincrease.SharedServices.utils.YogaUtils;


import com.soldincrease.SharedServices.dto.YogaDto.YogaMovementDto;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaMovementEntity;

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

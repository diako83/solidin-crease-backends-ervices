package com.soldincrease.SharedServices.utils.HiitUtil;


import com.soldincrease.SharedServices.dto.HiitDto.HiitMovementDto;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitMovementEntity;

public class EntityToHiitMovementDto {

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

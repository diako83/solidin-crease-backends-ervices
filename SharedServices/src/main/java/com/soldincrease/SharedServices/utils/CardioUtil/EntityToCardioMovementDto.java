package com.soldincrease.SharedServices.utils.CardioUtil;


import com.soldincrease.SharedServices.dto.CardioDto.CardioMovementDto;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioMovementEntity;

public class EntityToCardioMovementDto {

    public static CardioMovementDto entityToCardioMovementDto(CardioMovementEntity movement){

        return CardioMovementDto.builder()
                .id("")
                .name(movement.name)
                .timer(EntityToTimerDto.entityToTimerDto(movement.timer))
                .distance( EntityToDistanceDto.entityToDistanceDto(movement.distance))
                .build();

    }
}

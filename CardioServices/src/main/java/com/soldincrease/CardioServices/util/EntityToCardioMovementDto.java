package com.soldincrease.CardioServices.util;


import com.soldincrease.CardioServices.dto.CardioMovementDto;
import com.soldincrease.CardioServices.entity.CardioMovementEntity;

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

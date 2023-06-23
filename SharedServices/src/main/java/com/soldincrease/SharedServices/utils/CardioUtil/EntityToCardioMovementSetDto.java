package com.soldincrease.SharedServices.utils.CardioUtil;


import com.soldincrease.SharedServices.dto.CardioDto.CardioMovementDto;
import com.soldincrease.SharedServices.dto.CardioDto.CardioMovementSetDto;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioMovementSetEntity;

import java.util.List;

public class EntityToCardioMovementSetDto {

    public static CardioMovementSetDto entityToCardioMovementSetDto(CardioMovementSetEntity cardioMovementSet){

      List<CardioMovementDto> kbMovementDtos = cardioMovementSet.movements.stream().map(EntityToCardioMovementDto::entityToCardioMovementDto).toList();

        return CardioMovementSetDto.builder()
                .id("")
                .movements(kbMovementDtos )
                .build();
    }

}

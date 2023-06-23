package com.soldincrease.CardioServices.util;






import com.soldincrease.CardioServices.dto.CardioMovementDto;
import com.soldincrease.CardioServices.dto.CardioMovementSetDto;
import com.soldincrease.CardioServices.entity.CardioMovementSetEntity;

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

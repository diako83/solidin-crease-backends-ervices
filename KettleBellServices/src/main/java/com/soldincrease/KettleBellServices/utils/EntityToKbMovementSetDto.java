package com.soldincrease.KettleBellServices.utils;

import com.soldincrease.KettleBellServices.dto.KbMovementDto;
import com.soldincrease.KettleBellServices.dto.KbMovementSetDto;
import com.soldincrease.KettleBellServices.entity.KbMovementSetEntity;

import java.util.List;


public class EntityToKbMovementSetDto {

    public static KbMovementSetDto entityToKbMovementSetDto(KbMovementSetEntity kbMovementSet){

      List<KbMovementDto>  kbMovementDtos = kbMovementSet.movements.stream().map(EntityToKbMovementDto::entityToKbMovementDto).toList();

        return KbMovementSetDto.builder()
                .id("")
                .movements(kbMovementDtos )
                .build();
    }

}

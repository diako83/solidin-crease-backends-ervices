package com.soldincrease.YogaServices.utils;


import com.soldincrease.YogaServices.dto.YogaMovementDto;
import com.soldincrease.YogaServices.dto.YogaMovementSetDto;
import com.soldincrease.YogaServices.entity.YogaMovementSetEntity;

import java.util.List;


public class EntityToMovementSetDto {

    public static YogaMovementSetDto entityToKbMovementSetDto(YogaMovementSetEntity kbMovementSet){

      List<YogaMovementDto>  kbMovementDtos = kbMovementSet.movements.stream().map(EntityToYogaMovementDto::entityToKbMovementDto).toList();

        return YogaMovementSetDto.builder()
                .id("")
                .movements(kbMovementDtos )
                .build();
    }

}

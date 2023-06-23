package com.soldincrease.SharedServices.utils.KbUtils;


import com.soldincrease.SharedServices.dto.KbDto.KbMovementDto;
import com.soldincrease.SharedServices.dto.KbDto.KbMovementSetDto;
import com.soldincrease.SharedServices.entity.KbEntitys.KbMovementSetEntity;

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

package com.soldincrease.SharedServices.utils.YogaUtils;


import com.soldincrease.SharedServices.dto.YogaDto.YogaMovementDto;
import com.soldincrease.SharedServices.dto.YogaDto.YogaMovementSetDto;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaMovementSetEntity;

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

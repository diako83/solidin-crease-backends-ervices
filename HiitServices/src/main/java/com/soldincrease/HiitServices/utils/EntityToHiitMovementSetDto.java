package com.soldincrease.HiitServices.utils;


import com.soldincrease.HiitServices.dto.HiitMovementDto;
import com.soldincrease.HiitServices.dto.HiitMovementSetDto;
import com.soldincrease.HiitServices.entity.HiitMovementSetEntity;

import java.util.List;

public class EntityToHiitMovementSetDto {

    public static HiitMovementSetDto entityToHiitMovementSetDto(HiitMovementSetEntity kbMovementSet){

      List<HiitMovementDto> kbMovementDtos = kbMovementSet.movements.stream().map(EntityToKbMovementDto::entityToHiitMovementDto).toList();

        return HiitMovementSetDto.builder()
                .id("")
                .movements(kbMovementDtos )
                .build();
    }

}

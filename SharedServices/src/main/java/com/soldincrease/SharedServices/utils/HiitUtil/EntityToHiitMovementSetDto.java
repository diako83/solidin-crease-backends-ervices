package com.soldincrease.SharedServices.utils.HiitUtil;


import com.soldincrease.SharedServices.dto.HiitDto.HiitMovementDto;
import com.soldincrease.SharedServices.dto.HiitDto.HiitMovementSetDto;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitMovementSetEntity;

import java.util.List;

public class EntityToHiitMovementSetDto {

    public static HiitMovementSetDto entityToHiitMovementSetDto(HiitMovementSetEntity kbMovementSet){

      List<HiitMovementDto> kbMovementDtos = kbMovementSet.movements.stream().map(EntityToHiitMovementDto::entityToHiitMovementDto).toList();

        return HiitMovementSetDto.builder()
                .id("")
                .movements(kbMovementDtos )
                .build();
    }

}

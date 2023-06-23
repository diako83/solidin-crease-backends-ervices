package com.soldincrease.SharedServices.utils.KbUtils;


import com.soldincrease.SharedServices.dto.KbDto.DistanceDto;
import com.soldincrease.SharedServices.entity.KbEntitys.KbDistanceEntity;

public class EntityToDistanceDto {

    public static DistanceDto entityToDistanceDto(KbDistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

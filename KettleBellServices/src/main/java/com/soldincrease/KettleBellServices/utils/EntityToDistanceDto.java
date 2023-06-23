package com.soldincrease.KettleBellServices.utils;

import com.soldincrease.KettleBellServices.dto.DistanceDto;
import com.soldincrease.KettleBellServices.entity.DistanceEntity;


public class EntityToDistanceDto {



    public static DistanceDto entityToDistanceDto(DistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

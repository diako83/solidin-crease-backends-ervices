package com.soldincrease.HiitServices.utils;


import com.soldincrease.HiitServices.dto.DistanceDto;
import com.soldincrease.HiitServices.entity.DistanceEntity;

public class EntityToDistanceDto {



    public static DistanceDto entityToDistanceDto(DistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

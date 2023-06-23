package com.soldincrease.CardioServices.util;


import com.soldincrease.CardioServices.dto.DistanceDto;
import com.soldincrease.CardioServices.entity.DistanceEntity;

public class EntityToDistanceDto {



    public static DistanceDto entityToDistanceDto(DistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

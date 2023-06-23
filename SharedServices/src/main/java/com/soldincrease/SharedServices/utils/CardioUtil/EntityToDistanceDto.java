package com.soldincrease.SharedServices.utils.CardioUtil;


import com.soldincrease.SharedServices.dto.CardioDto.DistanceDto;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioDistanceEntity;

public class EntityToDistanceDto {



    public static DistanceDto entityToDistanceDto(CardioDistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

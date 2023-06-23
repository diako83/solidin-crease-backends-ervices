package com.soldincrease.SharedServices.utils.HiitUtil;


import com.soldincrease.SharedServices.dto.HiitDto.DistanceDto;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitDistanceEntity;

public class EntityToDistanceDto {



    public static DistanceDto entityToDistanceDto(HiitDistanceEntity distance){
        return DistanceDto.builder()
                .id("")
                .km(distance.km)
                .meter(distance.meter)
                .build();
    }
}

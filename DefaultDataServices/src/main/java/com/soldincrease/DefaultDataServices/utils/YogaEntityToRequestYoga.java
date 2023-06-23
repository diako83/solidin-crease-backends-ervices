package com.soldincrease.DefaultDataServices.utils;

import com.soldincrease.DefaultDataServices.dto.YogaDtos.RequestYoga;
import com.soldincrease.DefaultDataServices.entity.YogaEntity;

public class YogaEntityToRequestYoga {

    public static RequestYoga yogaEntityToRequestYoga(YogaEntity yogaEntity){

        return RequestYoga.builder()
                .title(yogaEntity.getTitle())
                .movements(yogaEntity.getMovements())
                .build();
    }
}

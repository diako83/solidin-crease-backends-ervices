package com.soldincrease.DefaultDataServices.utils;

import com.soldincrease.DefaultDataServices.dto.GymDtos.RequestGym;
import com.soldincrease.DefaultDataServices.entity.GymEntity;

public class GymEntityToRequestGym {

    public static RequestGym gymEntityToRequestGym(GymEntity gymEntity){

        return RequestGym.builder()
                .title(gymEntity.getTitle())
                .movements(gymEntity.getMovements())
                .build();

    }
}

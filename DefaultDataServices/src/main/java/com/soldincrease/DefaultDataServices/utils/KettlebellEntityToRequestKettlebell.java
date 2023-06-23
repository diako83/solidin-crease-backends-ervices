package com.soldincrease.DefaultDataServices.utils;

import com.soldincrease.DefaultDataServices.dto.KettlebellDto.RequestKettlebell;
import com.soldincrease.DefaultDataServices.entity.KettlebellEntity;

public class KettlebellEntityToRequestKettlebell {
    public static RequestKettlebell kettlebellEntityToRequestKettlebell(KettlebellEntity kettlebellEntity){

        return RequestKettlebell.builder()
                .title(kettlebellEntity.getTitle())
                .movements(kettlebellEntity.getMovements())
                .build();
    }
}

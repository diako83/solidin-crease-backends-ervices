package com.soldincrease.DefaultDataServices.interfaces;

import com.soldincrease.DefaultDataServices.dto.KettlebellDto.RequestKettlebell;
import com.soldincrease.DefaultDataServices.entity.KettlebellEntity;

import java.util.stream.Stream;

public interface IKettlebellServices {
    KettlebellEntity setKettlebellExercises(RequestKettlebell requestKettlebell);
    Stream<KettlebellEntity> getKettlebellExercises();
}

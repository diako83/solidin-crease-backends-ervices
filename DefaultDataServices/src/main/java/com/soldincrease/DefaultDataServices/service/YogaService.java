package com.soldincrease.DefaultDataServices.service;

import com.soldincrease.DefaultDataServices.dto.YogaDtos.RequestYoga;
import com.soldincrease.DefaultDataServices.entity.YogaEntity;
import com.soldincrease.DefaultDataServices.interfaces.IYogaServices;
import com.soldincrease.DefaultDataServices.repository.YogaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class YogaService implements IYogaServices {

    private final YogaRepository yogaRepository;

    public YogaEntity setYogaExercises(RequestYoga requestYoga){
        UUID uuid = UUID.randomUUID();
        YogaEntity yogaEntity = YogaEntity.builder()
                .id(uuid.toString())
                .title(requestYoga.getTitle())
                .movements(requestYoga.getMovements())
                .build();


        return yogaRepository.save(yogaEntity);


    }


    public Stream<YogaEntity> getYogaExercises() {

        return yogaRepository.findAll().stream();
    }
}

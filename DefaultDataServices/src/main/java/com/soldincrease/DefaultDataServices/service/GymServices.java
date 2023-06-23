package com.soldincrease.DefaultDataServices.service;


import com.soldincrease.DefaultDataServices.dto.GymDtos.RequestGym;
import com.soldincrease.DefaultDataServices.entity.GymEntity;
import com.soldincrease.DefaultDataServices.interfaces.IGymServices;
import com.soldincrease.DefaultDataServices.repository.GymRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class GymServices implements IGymServices {


    private final GymRepository gymRepository;

    public GymEntity setGymExercises(RequestGym gymEntity){
        UUID uuid = UUID.randomUUID();
       GymEntity gymEntity1 = GymEntity.builder()
            .id(uuid.toString())
            .title(gymEntity.title)
            .movements(gymEntity.movements)
            .build();


        return gymRepository.save(gymEntity1);


    }


    public Stream<GymEntity> getGymExercises() {

        return gymRepository.findAll().stream();
    }
}

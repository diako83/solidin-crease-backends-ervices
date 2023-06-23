package com.soldincrease.DefaultDataServices.service;

import com.soldincrease.DefaultDataServices.dto.KettlebellDto.RequestKettlebell;
import com.soldincrease.DefaultDataServices.entity.KettlebellEntity;
import com.soldincrease.DefaultDataServices.interfaces.IKettlebellServices;
import com.soldincrease.DefaultDataServices.repository.KettlebellRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class KettlebellService  implements IKettlebellServices {

    private final KettlebellRepository kettlebellRepository;

    public KettlebellEntity setKettlebellExercises(RequestKettlebell requestKettlebell){
        UUID uuid = UUID.randomUUID();
        KettlebellEntity kettlebellEntity = KettlebellEntity.builder()
                .id(uuid.toString())
                .title(requestKettlebell.getTitle())
                .movements(requestKettlebell.getMovements())
                .build();


        return kettlebellRepository.save(kettlebellEntity);


    }


    public Stream<KettlebellEntity> getKettlebellExercises() {

        return kettlebellRepository.findAll().stream();
    }
}

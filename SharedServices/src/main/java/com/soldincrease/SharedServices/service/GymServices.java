package com.soldincrease.SharedServices.service;


import com.soldincrease.SharedServices.dto.GymDtos.RequestGymWorkout;
import com.soldincrease.SharedServices.entity.GymEntitys.GymMovementEntity;
import com.soldincrease.SharedServices.entity.GymEntitys.GymMovementSetEntity;
import com.soldincrease.SharedServices.entity.GymEntitys.GymWorkoutEntity;
import com.soldincrease.SharedServices.interfaces.IGymServices;
import com.soldincrease.SharedServices.repository.GymRepositorys.GymMovementRepo;
import com.soldincrease.SharedServices.repository.GymRepositorys.GymMovementSetRepo;
import com.soldincrease.SharedServices.repository.GymRepositorys.GymRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor
@Service
public class GymServices implements IGymServices {

    private final GymRepository gymRepository;
    private final GymMovementSetRepo gymMovementSetRepo;
    private final GymMovementRepo gymMovementRepo;
    public GymWorkoutEntity postGymWorkout(RequestGymWorkout requestGymWorkout) {
         LocalDate creation_date = LocalDate.now();
        UUID uuid = UUID.randomUUID();

        GymWorkoutEntity gymWorkoutEntity = GymWorkoutEntity.builder()
                .id(uuid.toString())
                .title(requestGymWorkout.getTitle())
                .description(requestGymWorkout.getDescription())
                .creation_date(creation_date)
                .author(requestGymWorkout.getAuthor())
                .share(requestGymWorkout.getShare())
                .build();




        List<GymMovementSetEntity> gymMovementSetEntities = requestGymWorkout.getMovements_sets()
                .stream()
                .map(item -> {
                    GymMovementSetEntity entity = new GymMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj->{
                       GymMovementEntity gymMovementEntity = new GymMovementEntity();
                       gymMovementEntity.setId(UUID.randomUUID().toString());
                       gymMovementEntity.setName(obj.getName());
                       gymMovementEntity.setSets(obj.getSets());
                       gymMovementEntity.setReps(obj.getReps());
                       gymMovementEntity.setWeight(obj.getWeight());
                       gymMovementEntity.setImgUrl(obj.getImgUrl());
                       gymMovementEntity.setMovementSet(entity);
                       return  gymMovementEntity;
                   })   .collect(Collectors.toList()));
                    entity.setWorkout(gymWorkoutEntity);
                    return entity;
                })
                .collect(Collectors.toList());

        gymWorkoutEntity.setMovementSets(gymMovementSetEntities);
        return gymRepository.save(gymWorkoutEntity);
    }

    public Stream<GymWorkoutEntity > getAll() {

        Random random = new Random();
        int number= (int) gymRepository.count()/8;

        int randomNumber =0;
        if(number>0) {
             randomNumber = random.nextInt(number);
        }
        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return gymRepository.findAll(firstPageWithTwoElements ).stream();
    }

}

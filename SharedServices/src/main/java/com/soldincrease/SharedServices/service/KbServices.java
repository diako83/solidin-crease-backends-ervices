package com.soldincrease.SharedServices.service;


import com.soldincrease.SharedServices.dto.KbDto.RequestKbWorkout;
import com.soldincrease.SharedServices.entity.KbEntitys.*;
import com.soldincrease.SharedServices.interfaces.IKbServices;
import com.soldincrease.SharedServices.repository.KbRepositorya.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class KbServices implements IKbServices {

    private final KbWorkoutRepo kbWorkoutRepo;
    private final KbMovementSetRepo kbMovementSetRepo;
    private final KbMovementRepo kbMovementRepo;
    private final KbTimerRepo timerRepo;
    private final KbDistanceRepo distanceRepo;


    public KbWorkoutEntity postKbWorkout(RequestKbWorkout requestKbWorkout) {

         LocalDate creation_date  = LocalDate.now();


        UUID uuid = UUID.randomUUID();

        KbWorkoutEntity kbWorkoutEntity = KbWorkoutEntity.builder()
                .id(uuid.toString())
                .title(requestKbWorkout.getTitle())
                .description(requestKbWorkout.getDescription())
                .creation_date(creation_date)
                .author(requestKbWorkout.getAuthor())
                .share(requestKbWorkout.share)
                .build();

        System.out.println(kbWorkoutEntity);


        List<KbMovementSetEntity> kbMovementSetEntities = requestKbWorkout.getMovements_sets().stream()
                .map(item-> {
                    KbMovementSetEntity entity = new KbMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                KbMovementEntity kbMovementEntity = new KbMovementEntity();

                                kbMovementEntity.setDistance( new KbDistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,kbMovementEntity));
                                kbMovementEntity.setTimer( new KbTimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,kbMovementEntity));
                                kbMovementEntity.setId(UUID.randomUUID().toString());
                                kbMovementEntity.setName(obj.getName());
                                kbMovementEntity.setSets(obj.getSets());
                                kbMovementEntity.setReps(obj.getReps());
                                kbMovementEntity.setWeight(obj.getWeight());
                                kbMovementEntity.setImgUrl(obj.getImgUrl());
                                kbMovementEntity.setHiitMovementSet(entity);
                                return kbMovementEntity;
                            }).collect(Collectors.toList()));
                    entity.setWorkout(kbWorkoutEntity);
                    return entity;
                } ).collect(Collectors.toList());

        kbWorkoutEntity.setMovements_sets( kbMovementSetEntities);


       kbWorkoutRepo.save(kbWorkoutEntity);

       return kbWorkoutEntity;

    }

    public Stream<KbWorkoutEntity> getAll() {

        Random random = new Random();
        int number= (int) kbWorkoutRepo.count()/8;

        int randomNumber =0;
        if(number>0) {
            randomNumber = random.nextInt(number);
        }
        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return kbWorkoutRepo.findAll(firstPageWithTwoElements ).stream();
    }

}

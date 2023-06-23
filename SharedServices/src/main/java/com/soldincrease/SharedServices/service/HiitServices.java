package com.soldincrease.SharedServices.service;

import com.soldincrease.SharedServices.dto.HiitDto.RequestHiitWorkout;
import com.soldincrease.SharedServices.entity.HiitEntitys.*;
import com.soldincrease.SharedServices.interfaces.IHiitServices;
import com.soldincrease.SharedServices.repository.HiitRepositorya.*;
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
public class HiitServices implements IHiitServices {

    private final HiitWorkoutRepo hiitWorkoutRepo;
    private final HiitMovementSetRepo hiitMovementSetRepo;
    private final HiitMovementRepo hiitMovementRepo;
    private final HiitTimerRepo timerRepo;
    private final HiitDistanceRepo distanceRepo;


    public HiitWorkoutEntity postHiitWorkout(RequestHiitWorkout requestHiitWorkout) {
       LocalDate creation_date = LocalDate.now();

        UUID uuid = UUID.randomUUID();

        HiitWorkoutEntity hiitWorkoutEntity = HiitWorkoutEntity.builder()
                .id(uuid.toString())
                .title(requestHiitWorkout.getTitle())
                .description(requestHiitWorkout.getDescription())
                .creation_date(creation_date)
                .author(requestHiitWorkout.getAuthor())
                .share(requestHiitWorkout.share)
                .build();


        List<HiitMovementSetEntity> hiitMovementSetEntities = requestHiitWorkout.getMovements_sets().stream()
                .map(item-> {
                    HiitMovementSetEntity entity = new HiitMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                HiitMovementEntity hiitMovementEntity = new HiitMovementEntity();

                                hiitMovementEntity.setDistance( new HiitDistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,hiitMovementEntity));
                                hiitMovementEntity.setTimer( new HiitTimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,hiitMovementEntity));
                                hiitMovementEntity.setId(UUID.randomUUID().toString());
                                hiitMovementEntity.setName(obj.getName());
                                hiitMovementEntity.setSets(obj.getSets());
                                hiitMovementEntity.setReps(obj.getReps());
                                hiitMovementEntity.setWeight(obj.getWeight());
                                hiitMovementEntity.setImgUrl(obj.getImgUrl());
                                hiitMovementEntity.setHiitMovementSet(entity);
                                return hiitMovementEntity;
                            }).collect(Collectors.toList()));
                    entity.setHiitWorkout(hiitWorkoutEntity);
                    return entity;
                } ).collect(Collectors.toList());

        hiitWorkoutEntity.setMovements_sets( hiitMovementSetEntities);


        return  hiitWorkoutRepo.save(hiitWorkoutEntity);
    }

    public Stream<HiitWorkoutEntity> getAll() {

        Random random = new Random();
        int number= (int) hiitWorkoutRepo.count()/8;

        int randomNumber =0;
        if(number>0) {
            randomNumber = random.nextInt(number);
        }
        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return hiitWorkoutRepo.findAll(firstPageWithTwoElements ).stream();
    }

}

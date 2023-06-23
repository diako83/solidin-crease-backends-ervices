package com.soldincrease.SharedServices.service;


import com.soldincrease.SharedServices.dto.YogaDto.RequestYogaWorkout;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaMovementEntity;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaMovementSetEntity;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaTimerEntity;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaWorkoutEntity;
import com.soldincrease.SharedServices.interfaces.IYogaServices;
import com.soldincrease.SharedServices.repository.YogaRepositorya.YogaMovementRepo;
import com.soldincrease.SharedServices.repository.YogaRepositorya.YogaMovementSetRepo;
import com.soldincrease.SharedServices.repository.YogaRepositorya.YogaTimerRepo;
import com.soldincrease.SharedServices.repository.YogaRepositorya.YogaWorkoutRepo;
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
public class YogaServices implements IYogaServices {

    private final YogaWorkoutRepo yogaWorkoutRepo;
    private final YogaMovementSetRepo yogaMovementSetRepo;
    private final YogaMovementRepo yogaMovementRepo;
    private final YogaTimerRepo timerRepo;



    public YogaWorkoutEntity postWorkout(RequestYogaWorkout requestYogaWorkout) {


        LocalDate currentDate = LocalDate.now();

        UUID uuid = UUID.randomUUID();

        YogaWorkoutEntity kbWorkoutEntity = YogaWorkoutEntity.builder()
                .id(uuid.toString())
                .title(requestYogaWorkout.getTitle())
                .description(requestYogaWorkout.getDescription())
                .creation_date(currentDate)
                .author(requestYogaWorkout.getAuthor())
                .share(requestYogaWorkout.share)
                .build();

        System.out.println(kbWorkoutEntity);


        List<YogaMovementSetEntity> yogaMovementSetEntities = requestYogaWorkout.getMovements_sets().stream()
                .map(item-> {
                    YogaMovementSetEntity entity = new YogaMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                YogaMovementEntity yogaMovementEntity = new YogaMovementEntity();


                                yogaMovementEntity.setTimer( new YogaTimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,yogaMovementEntity));
                                yogaMovementEntity.setId(UUID.randomUUID().toString());
                                yogaMovementEntity.setName(obj.getName());
                                yogaMovementEntity.setSets(obj.getSets());
                                yogaMovementEntity.setReps(obj.getReps());

                                yogaMovementEntity.setImgUrl(obj.getImgUrl());
                                yogaMovementEntity.setMovementSet(entity);
                                return yogaMovementEntity;
                            }).collect(Collectors.toList()));
                    entity.setWorkout(kbWorkoutEntity);
                    return entity;
                } ).collect(Collectors.toList());

        kbWorkoutEntity.setMovements_sets( yogaMovementSetEntities);


       yogaWorkoutRepo.save(kbWorkoutEntity);

       return kbWorkoutEntity;

    }

    public String dateTimeNowToString(){
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Convert the year, month, and day to a string
        String dateString = currentDate.getYear() + "-" + currentDate.getMonthValue() + "-" + currentDate.getDayOfMonth();

        return dateString;

    }
    public LocalDate sortDteTimeNowToString(){
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Subtract one week from the current date
        LocalDate oneWeekAgo = currentDate.minusWeeks(1);

        return oneWeekAgo;
    }

    public Stream<YogaWorkoutEntity> getAllYoga() {

        Random random = new Random();
        int number= (int) yogaWorkoutRepo.count()/8;

        int randomNumber =0;
        if(number>0) {
            randomNumber = random.nextInt(number);
        }

        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return yogaWorkoutRepo.findAll(firstPageWithTwoElements ).stream();
    }
}

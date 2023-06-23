package com.soldincrease.SharedServices.service;


import com.soldincrease.SharedServices.dto.CardioDto.RequestCardioWorkout;
import com.soldincrease.SharedServices.entity.CardioEntitys.*;
import com.soldincrease.SharedServices.interfaces.ICardioServices;
import com.soldincrease.SharedServices.repository.CardioRepository.*;
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
public class CardioServices implements ICardioServices {

    private final CardioWorkoutRepo cardioWorkoutRepo;
    private final CardioMovementSetRepo cardioMovementSetRepo;
    private final CardioMovementRepo cardioMovementRepo;
    private final CardioTimerRepo timerRepo;
    private final CardioDistanceRepo distanceRepo;


    public CardioWorkoutEntity postCardioWorkout(RequestCardioWorkout requestCardioWorkout) {
        LocalDate creation_date =LocalDate.now();
        UUID uuid = UUID.randomUUID();

        CardioWorkoutEntity cardioWorkoutEntity = CardioWorkoutEntity.builder()
                .id(uuid.toString())
                .title(requestCardioWorkout.getTitle())
                .description(requestCardioWorkout.getDescription())
                .creation_date(creation_date)
                .author(requestCardioWorkout.getAuthor())
                .share(requestCardioWorkout.share)
                .build();


        List<CardioMovementSetEntity> cardioMovementSetEntities = requestCardioWorkout.getMovements_sets().stream()
                .map(item-> {
                    CardioMovementSetEntity entity = new CardioMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                CardioMovementEntity cardioMovementEntity = new CardioMovementEntity();

                                cardioMovementEntity.setDistance( new CardioDistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,cardioMovementEntity));
                                cardioMovementEntity.setTimer( new CardioTimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,cardioMovementEntity));
                                cardioMovementEntity.setId(UUID.randomUUID().toString());
                                cardioMovementEntity.setName(obj.getName());

                                cardioMovementEntity.setImgUrl(obj.getImgUrl());
                                cardioMovementEntity.setCardioMovementSet(entity);
                                return cardioMovementEntity;
                            }).collect(Collectors.toList()));
                    entity.setWorkout(cardioWorkoutEntity);
                    return entity;
                } ).collect(Collectors.toList());

        cardioWorkoutEntity.setMovements_sets( cardioMovementSetEntities);


        return  cardioWorkoutRepo.save(cardioWorkoutEntity);
    }



    public Stream<CardioWorkoutEntity> getAllCardio() {
        Random random = new Random();
        int number= (int) cardioWorkoutRepo.count()/8;
    long co =    cardioWorkoutRepo.count();
        System.out.println(co);
        int randomNumber =0;
        if(number>0) {
             randomNumber = random.nextInt(number);
        }


        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return cardioWorkoutRepo.findAll(firstPageWithTwoElements ).stream();
    }
}

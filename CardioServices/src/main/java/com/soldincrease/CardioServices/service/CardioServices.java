package com.soldincrease.CardioServices.service;


import com.soldincrease.CardioServices.dto.RequestCardioWorkout;
import com.soldincrease.CardioServices.entity.*;
import com.soldincrease.CardioServices.repository.*;
import com.soldincrease.CardioServices.util.EntityToCardioWorkoutDto;
import com.soldincrease.FeignServices.model.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@AllArgsConstructor

@Service
public class CardioServices implements ICardioServices{

    private final CardioWorkoutRepo cardioWorkoutRepo;
    private final CardioMovementSetRepo cardioMovementSetRepo;
    private final CardioMovementRepo cardioMovementRepo;
    private final TimerRepo timerRepo;
    private final DistanceRepo distanceRepo;




    public CardioWorkoutEntity postCardioWorkout(RequestCardioWorkout requestCardioWorkout) {
     LocalDate creation_date =LocalDate.now();
        UUID uuid = UUID.randomUUID();

        CardioWorkoutEntity cardioWorkoutEntity = CardioWorkoutEntity.builder()
                .id(uuid.toString())
                .userId(requestCardioWorkout.userId)
                .title(requestCardioWorkout.getTitle())
                .description(requestCardioWorkout.getDescription())
                .creation_date(creation_date)
                .author(removeEmailDomain(requestCardioWorkout.getAuthor()))
                .share(requestCardioWorkout.share)
                .build();


        List<CardioMovementSetEntity> cardioMovementSetEntities = requestCardioWorkout.getMovementSets().stream()
                .map(item-> {
                    CardioMovementSetEntity entity = new CardioMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                CardioMovementEntity cardioMovementEntity = new CardioMovementEntity();

                                cardioMovementEntity.setDistance( new DistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,cardioMovementEntity));
                                cardioMovementEntity.setTimer( new TimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,cardioMovementEntity));
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


/*
    if(requestCardioWorkout.share == true) {
        WebClient webClient = WebClient.create();
        webClient.post()
                .uri("http://localhost:9090/api/v2/cardio")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestCardioWorkout), RequestCardioWorkout.class)
                .retrieve()
                .bodyToMono(RequestCardioWorkout.class)
                .subscribe(response -> {
                    // Handle the response here
                    System.out.println(response);
                });

    }
*/
        return  cardioWorkoutRepo.save(cardioWorkoutEntity);
    }


    public static String removeEmailDomain(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return email;
    }

    public Stream<CardioWorkoutEntity> getAllCardio() {
        Random random = new Random();
        int number= (int) cardioWorkoutRepo.count()/8;
        int randomNumber = random.nextInt(number);

        System.out.println("test log " +randomNumber);

        Pageable firstPageWithTwoElements = PageRequest.of(randomNumber, 8);
        return cardioWorkoutRepo.findAll(firstPageWithTwoElements ).stream();
    }

    @Override
    public ResponseModel getAllCardioWorkouts(String userId) {
        ResponseModel responseModel= new ResponseModel();
       List<RequestCardioWorkout>  cardioWorkoutEntity =   cardioWorkoutRepo.findAllByUserId(userId).stream().map(EntityToCardioWorkoutDto::entityToCardioWorkoutDto).collect(Collectors.toList());

        if(cardioWorkoutEntity!=null){
            responseModel.data = cardioWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel getSingleCardioWorkouts(String id) {
        ResponseModel responseModel= new ResponseModel();
      RequestCardioWorkout cardioWorkoutEntity = EntityToCardioWorkoutDto.entityToCardioWorkoutDto ( cardioWorkoutRepo.findById(id).get());

        if(cardioWorkoutEntity!=null){
            responseModel.data = cardioWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel deleteCardioWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            cardioWorkoutRepo.deleteById(id);
            responseModel.setData("Cardio workout deleted successfully.");
            responseModel.setStatus(200);
        } catch (Exception e) {
            responseModel.setData("Failed to delete cario workout.");
            responseModel.setStatus(0);
        }
        return responseModel;
    }



}

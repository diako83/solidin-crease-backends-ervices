package com.soldincrease.YogaServices.service;


import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.YogaServices.dto.RequestYogaWorkout;
import com.soldincrease.YogaServices.entity.TimerEntity;
import com.soldincrease.YogaServices.entity.YogaMovementEntity;
import com.soldincrease.YogaServices.entity.YogaMovementSetEntity;
import com.soldincrease.YogaServices.entity.YogaWorkoutEntity;
import com.soldincrease.YogaServices.repository.TimerRepo;
import com.soldincrease.YogaServices.repository.YogaMovementRepo;
import com.soldincrease.YogaServices.repository.YogaMovementSetRepo;
import com.soldincrease.YogaServices.repository.YogaWorkoutRepo;
import com.soldincrease.YogaServices.utils.EntityToWorkoutDto;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class YogaServices implements IYogaServices {

    private final YogaWorkoutRepo yogaWorkoutRepo;
    private final YogaMovementSetRepo yogaMovementSetRepo;
    private final YogaMovementRepo yogaMovementRepo;
    private final TimerRepo timerRepo;



    public YogaWorkoutEntity postWorkout(RequestYogaWorkout requestYogaWorkout) {

        LocalDate localDate = LocalDate.now();  // Create a date object


        UUID uuid = UUID.randomUUID();

        YogaWorkoutEntity kbWorkoutEntity = YogaWorkoutEntity.builder()
                .id(uuid.toString())
                .userId(requestYogaWorkout.getUserId())
                .title(requestYogaWorkout.getTitle())
                .description(requestYogaWorkout.getDescription())
                .creation_date(localDate)
                .author(removeEmailDomain(requestYogaWorkout.getAuthor()))
                .share(requestYogaWorkout.share)
                .build();

        System.out.println(kbWorkoutEntity);


        List<YogaMovementSetEntity> yogaMovementSetEntities = requestYogaWorkout.getMovementSets().stream()
                .map(item-> {
                    YogaMovementSetEntity entity = new YogaMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                YogaMovementEntity yogaMovementEntity = new YogaMovementEntity();


                                yogaMovementEntity.setTimer( new TimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,yogaMovementEntity));
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
/*        if(requestYogaWorkout.share == true) {
            WebClient webClient = WebClient.create();
            webClient.post()
                    .uri("http://localhost:9090/api/v2/yoga")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(requestYogaWorkout), RequestYogaWorkout.class)
                    .retrieve()
                    .bodyToMono(RequestYogaWorkout.class)
                    .subscribe(response -> {
                        // Handle the response here
                        System.out.println(response);
                    });

        }
        */

       return kbWorkoutEntity;

    }
    public static String removeEmailDomain(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return email;
    }
    @Override
    public ResponseModel getAllYogaWorkouts(String userId) {
        ResponseModel responseModel = new ResponseModel();
        List<RequestYogaWorkout> yogaWorkoutEntity =  yogaWorkoutRepo.findAllByUserId(userId)
                .stream()
                .map(EntityToWorkoutDto::entityToWorkoutDto)
                .toList();


        if(yogaWorkoutEntity!=null){
            responseModel.data = yogaWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel getSingleYogaWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        RequestYogaWorkout workoutEntity =EntityToWorkoutDto.entityToWorkoutDto (yogaWorkoutRepo.findById(id).get());

        if(workoutEntity!=null){
            responseModel.data = workoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel deleteYogaWorkout(String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            yogaWorkoutRepo.deleteById(id);
            responseModel.setData("Yoga workout deleted successfully.");
            responseModel.setStatus(200);
        } catch (Exception e) {
            responseModel.setData("Failed to delete Yoga workout.");
            responseModel.setStatus(0);
        }
        return responseModel;
    }



}

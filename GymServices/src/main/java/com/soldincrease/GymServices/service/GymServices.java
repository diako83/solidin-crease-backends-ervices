package com.soldincrease.GymServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.GymServices.dto.RequestGymWorkout;
import com.soldincrease.GymServices.entity.GymMovementEntity;
import com.soldincrease.GymServices.entity.GymMovementSetEntity;
import com.soldincrease.GymServices.entity.GymWorkoutEntity;
import com.soldincrease.GymServices.repository.GymMovementRepo;
import com.soldincrease.GymServices.repository.GymMovementSetRepo;
import com.soldincrease.GymServices.repository.GymRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
    public ResponseModel postGymWorkout(RequestGymWorkout requestGymWorkout) {
        LocalDate creation_date = LocalDate.now();
        UUID uuid = UUID.randomUUID();

        GymWorkoutEntity gymWorkoutEntity = GymWorkoutEntity.builder()
                .id(uuid.toString())
                .userId(requestGymWorkout.getUserId())
                .title(requestGymWorkout.getTitle())
                .description(requestGymWorkout.getDescription())
                .creation_date(creation_date)
                .author(removeEmailDomain(requestGymWorkout.getAuthor()))
                .share(requestGymWorkout.getShare())
                .build();




        List<GymMovementSetEntity> gymMovementSetEntities = requestGymWorkout.getMovementSets()
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

/*
        if(requestGymWorkout.getShare() == true) {
            WebClient webClient = WebClient.create();
            webClient.post()
                    .uri("http://localhost:9090/api/v2/gym")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(requestGymWorkout), RequestGymWorkout.class)
                    .retrieve()
                    .bodyToMono(RequestGymWorkout.class)
                    .subscribe(response -> {
                        // Handle the response here
                        System.out.println(response);
                    });

        }

 */
        GymWorkoutEntity gymWorkout =gymRepository.save(gymWorkoutEntity);
        ResponseModel<Object> responseModel = new ResponseModel<>();

        if (gymWorkout!= null) {
         responseModel.setData(gymWorkoutEntity);
           responseModel.setStatus(200);
        } else {
            responseModel.setStatus(403);
        }

       return responseModel;
    }

    @Override
    public ResponseModel getAllGymWorkouts(String userId) {
        ResponseModel responseModel = new ResponseModel();
        Stream<GymWorkoutEntity> gymWorkoutEntity =  gymRepository.findAllByUserId(userId).stream();
        if(gymWorkoutEntity!=null){
            responseModel.data = gymWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    public static String removeEmailDomain(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return email;
    }


    public ResponseModel getSingleGymWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        Optional<GymWorkoutEntity> gymWorkoutEntity = gymRepository.findById(id);

        if(gymWorkoutEntity!=null){
            responseModel.data = gymWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }

    }

    @Override
    public ResponseModel getDeleteGymWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            gymRepository.deleteById(id);
            responseModel.setData("Gym workout deleted successfully.");
            responseModel.setStatus(200);
        } catch (Exception e) {
            responseModel.setData("Failed to delete gym workout.");
            responseModel.setStatus(0);
        }
        return responseModel;
    }
}

package com.soldincrease.KettleBellServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.KettleBellServices.dto.RequestKbWorkout;
import com.soldincrease.KettleBellServices.entity.*;
import com.soldincrease.KettleBellServices.repository.*;
import com.soldincrease.KettleBellServices.utils.EntityToKbWorkoutDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class KbServices implements IKbService {

    private final KbWorkoutRepo kbWorkoutRepo;
    private final KbMovementSetRepo kbMovementSetRepo;
    private final KbMovementRepo kbMovementRepo;
    private final TimerRepo timerRepo;
    private final DistanceRepo distanceRepo;


    public KbWorkoutEntity postKbWorkout(RequestKbWorkout requestKbWorkout) {

     LocalDate creation_date = LocalDate.now();


        UUID uuid = UUID.randomUUID();

        KbWorkoutEntity kbWorkoutEntity = KbWorkoutEntity.builder()
                .id(uuid.toString())
                .userId(requestKbWorkout.getUserId())
                .title(requestKbWorkout.getTitle())
                .description(requestKbWorkout.getDescription())
                .creation_date(creation_date)
                .author(removeEmailDomain(requestKbWorkout.getAuthor()))
                .share(requestKbWorkout.share)
                .build();



        List<KbMovementSetEntity> kbMovementSetEntities = requestKbWorkout.getMovementSets().stream()
                .map(item-> {
                    KbMovementSetEntity entity = new KbMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());

                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                KbMovementEntity kbMovementEntity = new KbMovementEntity();

                                kbMovementEntity.setDistance( new DistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,kbMovementEntity));
                                kbMovementEntity.setTimer( new TimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,kbMovementEntity));
                                kbMovementEntity.setId(UUID.randomUUID().toString());
                                kbMovementEntity.setName(obj.getName());
                                kbMovementEntity.setSets(obj.getSets());
                                kbMovementEntity.setReps(obj.getReps());
                                kbMovementEntity.setWeight(obj.getWeight());
                                kbMovementEntity.setKbMovementSet(entity);
                                return kbMovementEntity;
                            }).collect(Collectors.toList()));
                    entity.setWorkout(kbWorkoutEntity);
                    return entity;
                } ).collect(Collectors.toList());

        kbWorkoutEntity.setMovements_sets( kbMovementSetEntities);


       kbWorkoutRepo.save(kbWorkoutEntity);

/*
        if(requestKbWorkout.share == true) {
            WebClient webClient = WebClient.create();
            webClient.post()
                    .uri("http://localhost:9090/api/v2/kb")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(requestKbWorkout), RequestKbWorkout.class)
                    .retrieve()
                    .bodyToMono(RequestKbWorkout.class)
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
    public ResponseModel getAllKbWorkouts(String userId) {
        ResponseModel responseModel = new ResponseModel();
      List<RequestKbWorkout> kbEntity =  kbWorkoutRepo.findAllByUserId(userId)
              .stream()
              .map(EntityToKbWorkoutDto::entityToKbWorkoutDto).toList();


        if(kbEntity!=null){
            responseModel.data = kbEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel getSingleKbWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        Optional<KbWorkoutEntity> kbWorkoutEntity = kbWorkoutRepo.findById(id);
      RequestKbWorkout requestKbWorkout = EntityToKbWorkoutDto.entityToKbWorkoutDto(kbWorkoutEntity.get());

        if(kbWorkoutEntity!=null){
            responseModel.data = requestKbWorkout;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel deleteKbWorkout(String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            kbWorkoutRepo.deleteById(id);
            responseModel.setData("Kb workout deleted successfully.");
            responseModel.setStatus(200);
        } catch (Exception e) {
            responseModel.setData("Failed to delete Kb workout.");
            responseModel.setStatus(0);
        }
        return responseModel;
    }



}

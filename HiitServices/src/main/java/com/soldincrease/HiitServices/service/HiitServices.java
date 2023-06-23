package com.soldincrease.HiitServices.service;

import com.soldincrease.FeignServices.model.ResponseModel;
import com.soldincrease.HiitServices.dto.RequestHiitWorkout;
import com.soldincrease.HiitServices.entity.*;
import com.soldincrease.HiitServices.repository.*;
import com.soldincrease.HiitServices.utils.EntityToHiitWorkoutDto;
import lombok.AllArgsConstructor;
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

@AllArgsConstructor
@Service
public class HiitServices implements IhiitServices{

    private final HiitWorkoutRepo hiitWorkoutRepo;
    private final HiitMovementSetRepo hiitMovementSetRepo;
    private final HiitMovementRepo hiitMovementRepo;
    private final TimerRepo timerRepo;
    private final DistanceRepo distanceRepo;


    public HiitWorkoutEntity postHiitWorkout(RequestHiitWorkout requestHiitWorkout) {
        LocalDate creation_date =LocalDate.now();
        UUID uuid = UUID.randomUUID();

        HiitWorkoutEntity hiitWorkoutEntity = HiitWorkoutEntity.builder()
                .id(uuid.toString())
                .userId(requestHiitWorkout.userId)
                .title(requestHiitWorkout.getTitle())
                .description(requestHiitWorkout.getDescription())
                .creation_date(creation_date)
                .author(removeEmailDomain(requestHiitWorkout.getAuthor()))
                .share(requestHiitWorkout.share)
                .build();


        List<HiitMovementSetEntity> hiitMovementSetEntities = requestHiitWorkout.getMovementSets().stream()
                .map(item-> {
                    HiitMovementSetEntity entity = new HiitMovementSetEntity();
                    entity.setId(UUID.randomUUID().toString());
                    entity.setMovements(
                            item.getMovements().stream().map(obj -> {
                                HiitMovementEntity hiitMovementEntity = new HiitMovementEntity();

                                hiitMovementEntity.setDistance( new DistanceEntity(UUID.randomUUID().toString(),obj.distance.km,obj.distance.meter,hiitMovementEntity));
                                hiitMovementEntity.setTimer( new TimerEntity(UUID.randomUUID().toString(),obj.timer.hours,obj.timer.minutes,obj.timer.seconds,hiitMovementEntity));
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
/*
        if(requestHiitWorkout.share == true) {
            WebClient webClient = WebClient.create();
            webClient.post()
                    .uri("http://localhost:9090/api/v2/hiit")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(requestHiitWorkout),RequestHiitWorkout.class)
                    .retrieve()
                    .bodyToMono(RequestHiitWorkout.class)
                    .subscribe(response -> {
                        // Handle the response here
                        System.out.println(response);
                    });

        }*/

        return  hiitWorkoutRepo.save(hiitWorkoutEntity);
    }

    public static String removeEmailDomain(String email) {
        int atIndex = email.indexOf("@");
        if (atIndex != -1) {
            return email.substring(0, atIndex);
        }
        return email;
    }

    @Override
    public ResponseModel getAllHiitWorkouts(String userId) {
        ResponseModel responseModel = new ResponseModel();
        Stream<HiitWorkoutEntity> hiitWorkoutEntity =  hiitWorkoutRepo.findAllByUserId(userId).stream();
        if(hiitWorkoutEntity!=null){
            responseModel.data = hiitWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel getSingleHiitWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
         RequestHiitWorkout hiitWorkoutEntity =   EntityToHiitWorkoutDto.entityToHiitWorkoutDto(hiitWorkoutRepo.findById(id).get());

        if(hiitWorkoutEntity!=null){
            responseModel.data = hiitWorkoutEntity;
            responseModel.status = 200;
            return responseModel;
        }else {
            responseModel.data = null;
            responseModel.status = 403;
            return responseModel;
        }
    }

    @Override
    public ResponseModel deleteHiitWorkouts(String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            hiitWorkoutRepo.deleteById(id);
            responseModel.setData("Hiit workout deleted successfully.");
            responseModel.setStatus(200);
        } catch (Exception e) {
            responseModel.setData("Failed to delete Hiit workout.");
            responseModel.setStatus(0);
        }
        return responseModel;
    }
/*
    public String dateTimeNowToString(){
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Convert the year, month, and day to a string
        String dateString = currentDate.getYear() + "-" + currentDate.getMonthValue() + "-" + currentDate.getDayOfMonth();

        return dateString;

    }

 */

}

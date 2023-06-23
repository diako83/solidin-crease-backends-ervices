package com.soldincrease.KettleBellServices.utils;

import com.soldincrease.KettleBellServices.dto.KbMovementSetDto;
import com.soldincrease.KettleBellServices.dto.RequestKbWorkout;
import com.soldincrease.KettleBellServices.entity.KbWorkoutEntity;

import java.util.List;


public class EntityToKbWorkoutDto {



    public static RequestKbWorkout entityToKbWorkoutDto(KbWorkoutEntity workout){

        List<KbMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToKbMovementSetDto::entityToKbMovementSetDto).toList();

       return RequestKbWorkout.builder()
               .id(workout.id)
               .userId(workout.userId)
               .title(workout.title)
               .description(workout.title)
               .creation_date(workout.creation_date)
               .author(workout.author)
               .share(workout.share)
               .movementSets(setDtos)
               .build();
    }

}

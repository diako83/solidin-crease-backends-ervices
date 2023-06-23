package com.soldincrease.YogaServices.utils;


import com.soldincrease.YogaServices.dto.RequestYogaWorkout;
import com.soldincrease.YogaServices.dto.YogaMovementSetDto;
import com.soldincrease.YogaServices.entity.YogaWorkoutEntity;

import java.util.List;


public class EntityToWorkoutDto {



    public static RequestYogaWorkout entityToWorkoutDto(YogaWorkoutEntity workout){

        List<YogaMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToMovementSetDto::entityToKbMovementSetDto).toList();

       return RequestYogaWorkout.builder()
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

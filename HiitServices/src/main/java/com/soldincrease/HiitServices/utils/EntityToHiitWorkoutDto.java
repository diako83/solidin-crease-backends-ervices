package com.soldincrease.HiitServices.utils;


import com.soldincrease.HiitServices.dto.HiitMovementSetDto;
import com.soldincrease.HiitServices.dto.RequestHiitWorkout;
import com.soldincrease.HiitServices.entity.HiitWorkoutEntity;

import java.util.List;

public class EntityToHiitWorkoutDto {

    public static RequestHiitWorkout entityToHiitWorkoutDto(HiitWorkoutEntity workout){

        List<HiitMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToHiitMovementSetDto::entityToHiitMovementSetDto).toList();

       return RequestHiitWorkout.builder()
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

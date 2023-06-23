package com.soldincrease.SharedServices.utils.CardioUtil;


import com.soldincrease.SharedServices.dto.CardioDto.CardioMovementSetDto;
import com.soldincrease.SharedServices.dto.CardioDto.RequestCardioWorkout;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioWorkoutEntity;

import java.util.List;

public class EntityToCardioWorkoutDto {

    public static RequestCardioWorkout entityToCardioWorkoutDto(CardioWorkoutEntity workout){

        List<CardioMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToCardioMovementSetDto::entityToCardioMovementSetDto).toList();

       return RequestCardioWorkout.builder()
               .id("")
               .title(workout.title)
               .description(workout.title)
               .creation_date(workout.creation_date)
               .author(workout.author)
               .share(workout.share)
               .movements_sets(setDtos)
               .build();
    }

}

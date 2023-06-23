package com.soldincrease.CardioServices.util;




import com.soldincrease.CardioServices.dto.CardioMovementSetDto;
import com.soldincrease.CardioServices.dto.RequestCardioWorkout;
import com.soldincrease.CardioServices.entity.CardioWorkoutEntity;

import java.util.List;

public class EntityToCardioWorkoutDto {

    public static RequestCardioWorkout entityToCardioWorkoutDto(CardioWorkoutEntity workout){

        List<CardioMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToCardioMovementSetDto::entityToCardioMovementSetDto).toList();

       return RequestCardioWorkout.builder()
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

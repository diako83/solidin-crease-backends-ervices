package com.soldincrease.SharedServices.utils.KbUtils;


import com.soldincrease.SharedServices.dto.KbDto.KbMovementSetDto;
import com.soldincrease.SharedServices.dto.KbDto.RequestKbWorkout;
import com.soldincrease.SharedServices.entity.KbEntitys.KbWorkoutEntity;

import java.util.List;


public class EntityToKbWorkoutDto {



    public static RequestKbWorkout entityToKbWorkoutDto(KbWorkoutEntity workout){

        List<KbMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToKbMovementSetDto::entityToKbMovementSetDto).toList();

       return RequestKbWorkout.builder()
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

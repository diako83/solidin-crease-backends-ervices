package com.soldincrease.SharedServices.utils.YogaUtils;


import com.soldincrease.SharedServices.dto.YogaDto.RequestYogaWorkout;
import com.soldincrease.SharedServices.dto.YogaDto.YogaMovementSetDto;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaWorkoutEntity;

import java.util.List;


public class EntityToWorkoutDto {



    public static RequestYogaWorkout entityToWorkoutDto(YogaWorkoutEntity workout){

        List<YogaMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToMovementSetDto::entityToKbMovementSetDto).toList();

       return RequestYogaWorkout.builder()
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

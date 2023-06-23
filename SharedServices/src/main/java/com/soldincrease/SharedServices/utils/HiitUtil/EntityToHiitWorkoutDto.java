package com.soldincrease.SharedServices.utils.HiitUtil;


import com.soldincrease.SharedServices.dto.HiitDto.HiitMovementSetDto;
import com.soldincrease.SharedServices.dto.HiitDto.RequestHiitWorkout;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitWorkoutEntity;

import java.util.List;

public class EntityToHiitWorkoutDto {

    public static RequestHiitWorkout entityToHiitWorkoutDto(HiitWorkoutEntity workout){

        List<HiitMovementSetDto> setDtos = workout.movements_sets.stream().map(EntityToHiitMovementSetDto::entityToHiitMovementSetDto).toList();

       return RequestHiitWorkout.builder()
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

package com.soldincrease.SharedServices.utils.YogaUtils;


import com.soldincrease.SharedServices.dto.YogaDto.TimerDto;
import com.soldincrease.SharedServices.entity.YogaEntitys.YogaTimerEntity;

public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(YogaTimerEntity timer){
       return TimerDto.builder()
               .id("")
               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

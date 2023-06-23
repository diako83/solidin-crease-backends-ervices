package com.soldincrease.YogaServices.utils;


import com.soldincrease.YogaServices.dto.TimerDto;
import com.soldincrease.YogaServices.entity.TimerEntity;

public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(TimerEntity timer){
       return TimerDto.builder()
               .id("")
               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

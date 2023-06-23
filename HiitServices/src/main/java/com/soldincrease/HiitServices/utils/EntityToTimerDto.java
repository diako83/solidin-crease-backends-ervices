package com.soldincrease.HiitServices.utils;


import com.soldincrease.HiitServices.dto.TimerDto;
import com.soldincrease.HiitServices.entity.TimerEntity;

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

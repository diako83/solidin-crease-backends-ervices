package com.soldincrease.KettleBellServices.utils;

import com.soldincrease.KettleBellServices.dto.TimerDto;
import com.soldincrease.KettleBellServices.entity.TimerEntity;


public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(TimerEntity timer){
       return TimerDto.builder()

               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

package com.soldincrease.CardioServices.util;


import com.soldincrease.CardioServices.dto.TimerDto;
import com.soldincrease.CardioServices.entity.TimerEntity;

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

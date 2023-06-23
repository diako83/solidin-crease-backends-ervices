package com.soldincrease.SharedServices.utils.CardioUtil;


import com.soldincrease.SharedServices.dto.CardioDto.TimerDto;
import com.soldincrease.SharedServices.entity.CardioEntitys.CardioTimerEntity;

public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(CardioTimerEntity timer){
       return TimerDto.builder()
               .id("")
               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

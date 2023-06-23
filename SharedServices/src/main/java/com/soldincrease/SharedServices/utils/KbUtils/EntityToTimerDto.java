package com.soldincrease.SharedServices.utils.KbUtils;


import com.soldincrease.SharedServices.dto.KbDto.TimerDto;
import com.soldincrease.SharedServices.entity.KbEntitys.KbTimerEntity;

public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(KbTimerEntity timer){
       return TimerDto.builder()
               .id("")
               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

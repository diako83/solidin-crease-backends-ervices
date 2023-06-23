package com.soldincrease.SharedServices.utils.HiitUtil;


import com.soldincrease.SharedServices.dto.HiitDto.TimerDto;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitTimerEntity;

public class EntityToTimerDto {
   public static TimerDto entityToTimerDto(HiitTimerEntity timer){
       return TimerDto.builder()
               .id("")
               .hours(timer.hours)
               .minutes(timer.minutes)
               .seconds(timer.seconds)
               .build();

   }
}

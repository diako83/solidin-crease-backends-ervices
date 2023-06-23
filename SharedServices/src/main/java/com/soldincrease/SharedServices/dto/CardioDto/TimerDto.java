package com.soldincrease.SharedServices.dto.CardioDto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimerDto {
    public String id;
    public int hours;
    public int minutes;
    public int seconds;

}

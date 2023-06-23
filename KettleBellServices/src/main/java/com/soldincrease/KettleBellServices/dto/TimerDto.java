package com.soldincrease.KettleBellServices.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TimerDto {

    public int hours;
    public int minutes;
    public int seconds;

}

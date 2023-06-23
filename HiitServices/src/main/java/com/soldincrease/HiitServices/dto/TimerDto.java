package com.soldincrease.HiitServices.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TimerDto {
    public String id;
    public int hours;
    public int minutes;
    public int seconds;

}

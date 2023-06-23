package com.soldincrease.KettleBellServices.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class KbMovementDto {
    public String id;
    public String name;
    public int sets;
    public int reps;
    public double weight;
    //public String imgUrl;

    public TimerDto timer;

    public DistanceDto distance;
}

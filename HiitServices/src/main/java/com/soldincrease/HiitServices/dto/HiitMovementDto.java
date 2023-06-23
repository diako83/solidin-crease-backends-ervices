package com.soldincrease.HiitServices.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HiitMovementDto {
    public String id;
    public String name;
    public int sets;
    public int reps;
    public double weight;
    public String imgUrl;

    public TimerDto timer;

    public DistanceDto distance;
}

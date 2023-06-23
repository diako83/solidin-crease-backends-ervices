package com.soldincrease.YogaServices.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class YogaMovementDto {
    public String id;
    public String name;
    public int sets;
    public int reps;
    public double weight;
    public String imgUrl;

    public TimerDto timer;


}

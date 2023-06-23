package com.soldincrease.CardioServices.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CardioMovementDto {
    public String id;
    public String name;
    public String imgUrl;

    public TimerDto timer;

    public DistanceDto distance;
}

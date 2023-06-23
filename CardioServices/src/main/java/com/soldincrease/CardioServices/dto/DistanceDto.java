package com.soldincrease.CardioServices.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class DistanceDto {
    public String id;
    public double km;
    public double meter;
}

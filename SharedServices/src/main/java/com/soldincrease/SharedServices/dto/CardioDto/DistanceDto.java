package com.soldincrease.SharedServices.dto.CardioDto;

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

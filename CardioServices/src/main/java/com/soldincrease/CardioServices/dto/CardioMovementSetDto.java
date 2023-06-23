package com.soldincrease.CardioServices.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CardioMovementSetDto {
    public String id;

    public List<CardioMovementDto> movements;

}

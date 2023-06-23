package com.soldincrease.CardioServices.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestCardioWorkout {
    public String id;
    public String userId;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public Boolean share;

    public List<CardioMovementSetDto> movementSets;
}

package com.soldincrease.SharedServices.dto.CardioDto;

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
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public Boolean share;

    public List<CardioMovementSetDto> movements_sets;
}

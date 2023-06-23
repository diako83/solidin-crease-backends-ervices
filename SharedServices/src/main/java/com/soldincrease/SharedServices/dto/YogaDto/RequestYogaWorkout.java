package com.soldincrease.SharedServices.dto.YogaDto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestYogaWorkout {
    public String id;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public Boolean share;

    public List<YogaMovementSetDto> movements_sets;
}

package com.soldincrease.SharedServices.dto.HiitDto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestHiitWorkout {
    public String id;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public Boolean share;

    public List<HiitMovementSetDto> movements_sets;
}

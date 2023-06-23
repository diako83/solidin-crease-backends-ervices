package com.soldincrease.SharedServices.dto.KbDto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestKbWorkout {
    public String id;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public Boolean share;

    public List<KbMovementSetDto> movements_sets;
}

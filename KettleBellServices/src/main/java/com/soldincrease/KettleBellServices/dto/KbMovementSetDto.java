package com.soldincrease.KettleBellServices.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class KbMovementSetDto {
    public String id;

    public List<KbMovementDto> movements;

}

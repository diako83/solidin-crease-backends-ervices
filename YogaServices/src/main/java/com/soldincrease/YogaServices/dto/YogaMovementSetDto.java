package com.soldincrease.YogaServices.dto;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class YogaMovementSetDto {
    public String id;

    public List<YogaMovementDto> movements;

}

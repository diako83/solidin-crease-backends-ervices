package com.soldincrease.SharedServices.dto.YogaDto;


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

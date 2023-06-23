package com.soldincrease.SharedServices.dto.KbDto;


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

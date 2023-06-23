package com.soldincrease.SharedServices.dto.HiitDto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HiitMovementSetDto {
    public String id;

    public List<HiitMovementDto> movements;

}

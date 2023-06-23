package com.soldincrease.SharedServices.dto.GymDtos;

import com.soldincrease.SharedServices.entity.GymEntitys.GymMovementSetEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGymWorkout {
    String id;
    String title;
    String description;
    String creation_date;
    String author;
    Boolean share;

    private List<GymMovementSetEntity> movements_sets;
}

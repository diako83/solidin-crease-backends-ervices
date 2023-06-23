package com.soldincrease.GymServices.dto;

import com.soldincrease.GymServices.entity.GymMovementSetEntity;
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
    String userId;
    String description;
    String creation_date;
    String author;
    Boolean share;

    private List<GymMovementSetEntity> movementSets;
}

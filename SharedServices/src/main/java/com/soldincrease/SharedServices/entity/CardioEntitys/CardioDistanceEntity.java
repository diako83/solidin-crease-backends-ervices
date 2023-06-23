package com.soldincrease.SharedServices.entity.CardioEntitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CardioDistanceEntity {
    @Id
    public String id;
    public double km;
    public double meter;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardio_movement_id")
    private CardioMovementEntity movementEntity;

}

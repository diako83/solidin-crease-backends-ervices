package com.soldincrease.SharedServices.entity.KbEntitys;

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
public class KbDistanceEntity {
    @Id
    public String id;
    public double km;
    public double meter;

    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hiit_movement_id")
    private KbMovementEntity movementEntity;

}

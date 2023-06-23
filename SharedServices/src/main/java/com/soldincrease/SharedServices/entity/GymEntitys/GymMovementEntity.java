package com.soldincrease.SharedServices.entity.GymEntitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymMovementEntity {
    @Id
    String id;
    String name;
    Double sets;
    Double  reps;
    Double weight;
    String imgUrl;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private GymMovementSetEntity movementSet;
}

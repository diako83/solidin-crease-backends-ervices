package com.soldincrease.SharedServices.entity.GymEntitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymMovementSetEntity {
    @Id
    public String id;


    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "movementSet"
    )
    private List<GymMovementEntity> movements = new ArrayList<>();

    @JsonBackReference
    @ManyToOne
    @JoinColumn(

            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "workout_fk")
    )
    private GymWorkoutEntity workout;


}

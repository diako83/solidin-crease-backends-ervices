package com.soldincrease.SharedServices.entity.KbEntitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KbMovementSetEntity {
    @Id
    public String id;



    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "hiitMovementSet"
    )
    public List<KbMovementEntity> movements;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(

            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "workout_fk")
    )
    private KbWorkoutEntity Workout;
}

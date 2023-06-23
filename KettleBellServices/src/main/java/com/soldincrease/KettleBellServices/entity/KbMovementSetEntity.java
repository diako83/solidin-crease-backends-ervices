package com.soldincrease.KettleBellServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class KbMovementSetEntity {
    @Id
    public String id;

    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "kbMovementSet"
    )
    public List<KbMovementEntity> movements;



    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(

            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "workout_fk")
    )
    private KbWorkoutEntity Workout;
}

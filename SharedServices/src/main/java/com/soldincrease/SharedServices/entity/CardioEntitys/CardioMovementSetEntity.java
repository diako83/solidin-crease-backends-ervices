package com.soldincrease.SharedServices.entity.CardioEntitys;

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
public class CardioMovementSetEntity {
    @Id
    public String id;



    @JsonManagedReference
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "cardioMovementSet"
    )
    public List<CardioMovementEntity> movements;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(

            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "workout_fk")
    )
    private CardioWorkoutEntity workout;
}

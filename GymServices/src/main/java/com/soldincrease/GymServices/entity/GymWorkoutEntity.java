package com.soldincrease.GymServices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymWorkoutEntity {
    @Id
    String id;
    String userId;
    String title;
    String description;
    LocalDate creation_date;
    String author;
    Boolean share;



    @JsonManagedReference
    @OneToMany(
            mappedBy = "workout",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    public List<GymMovementSetEntity> movementSets = new ArrayList<>();
}

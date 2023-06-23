package com.soldincrease.YogaServices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YogaWorkoutEntity {
    @Id
    public String id;
    public String userId;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public boolean share;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "Workout",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    public List<YogaMovementSetEntity> movements_sets;
}

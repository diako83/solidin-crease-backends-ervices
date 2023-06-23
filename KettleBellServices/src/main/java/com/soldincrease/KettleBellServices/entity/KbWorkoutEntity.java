package com.soldincrease.KettleBellServices.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class KbWorkoutEntity {
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
    public List<KbMovementSetEntity> movements_sets;
}

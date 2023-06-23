package com.soldincrease.SharedServices.entity.CardioEntitys;

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
public class CardioWorkoutEntity {
    @Id
    public String id;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public boolean share;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "workout",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    public List<CardioMovementSetEntity> movements_sets;
}

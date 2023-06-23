package com.soldincrease.SharedServices.entity.HiitEntitys;

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
public class HiitWorkoutEntity {
    @Id
    public String id;
    public String title;
    public String description;
    public LocalDate creation_date;
    public String author;
    public boolean share;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "hiitWorkout",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    public List<HiitMovementSetEntity> movements_sets;
}

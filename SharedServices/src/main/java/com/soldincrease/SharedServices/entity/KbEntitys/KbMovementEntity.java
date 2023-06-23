package com.soldincrease.SharedServices.entity.KbEntitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KbMovementEntity {
    @Id
    public String id;
    public String name;
    public int sets;
    public int reps;
    public double weight;
    public String imgUrl;

    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public KbTimerEntity timer;


    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public KbDistanceEntity distance;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private KbMovementSetEntity hiitMovementSet;

}

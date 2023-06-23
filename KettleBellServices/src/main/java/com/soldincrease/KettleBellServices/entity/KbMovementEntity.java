package com.soldincrease.KettleBellServices.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

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
public class KbMovementEntity {
    @Id
    public String id;
    public String name;
    public int sets;
    public int reps;
    public double weight;


    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public TimerEntity timer;


    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public DistanceEntity distance;


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private KbMovementSetEntity kbMovementSet;

}

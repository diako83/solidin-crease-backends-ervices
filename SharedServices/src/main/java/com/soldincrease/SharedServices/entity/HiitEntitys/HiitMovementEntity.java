package com.soldincrease.SharedServices.entity.HiitEntitys;

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
public class HiitMovementEntity {
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
    public HiitTimerEntity timer;


    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public HiitDistanceEntity distance;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private HiitMovementSetEntity hiitMovementSet;

}

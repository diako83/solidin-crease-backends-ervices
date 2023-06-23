package com.soldincrease.HiitServices.entity;

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
public class TimerEntity {
    @Id
    public String id;
    public int hours;
    public int minutes;
    public int seconds;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "hiit_movement_id")
    private HiitMovementEntity movementEntity;
}

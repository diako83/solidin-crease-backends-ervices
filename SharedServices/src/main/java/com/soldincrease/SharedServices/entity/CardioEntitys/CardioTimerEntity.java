package com.soldincrease.SharedServices.entity.CardioEntitys;

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
public class CardioTimerEntity {
    @Id
    public String id;
    public int hours;
    public int minutes;
    public int seconds;


    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "cardio_movement_id")
    private CardioMovementEntity movementEntity;
}

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
public class CardioMovementEntity {
    @Id
    public String id;
    public String name;
    public String imgUrl;

    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public CardioTimerEntity timer;


    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public CardioDistanceEntity distance;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private CardioMovementSetEntity cardioMovementSet;

}

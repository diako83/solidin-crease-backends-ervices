package com.soldincrease.SharedServices.entity.YogaEntitys;

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
public class YogaMovementEntity {
    @Id
    public String id;
    public String name;
    public int sets;
    public int reps;

    public String imgUrl;

    @JsonBackReference
    @OneToOne(mappedBy = "movementEntity", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    public YogaTimerEntity timer;





    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "set_fk")
    )
    private YogaMovementSetEntity MovementSet;

}

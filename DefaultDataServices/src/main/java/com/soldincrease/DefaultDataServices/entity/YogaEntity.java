package com.soldincrease.DefaultDataServices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YogaEntity {
    @Id
    @Column(name = "id")
    private String id;
    private String title;

    @ElementCollection
    private List<String> movements = new ArrayList<>();
}

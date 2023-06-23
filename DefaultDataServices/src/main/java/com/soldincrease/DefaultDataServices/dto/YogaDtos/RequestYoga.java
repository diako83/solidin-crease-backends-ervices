package com.soldincrease.DefaultDataServices.dto.YogaDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestYoga {
    private String title;
    private List<String> movements = new ArrayList<>();
}

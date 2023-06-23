package com.soldincrease.DefaultDataServices.dto.KettlebellDto;

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
public class RequestKettlebell {
    private String title;
    private List<String> movements = new ArrayList<>();
}

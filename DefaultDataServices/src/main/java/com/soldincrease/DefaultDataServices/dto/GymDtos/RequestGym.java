package com.soldincrease.DefaultDataServices.dto.GymDtos;

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
public class RequestGym {
   public String title;



    public List<String> movements = new ArrayList<>();
}

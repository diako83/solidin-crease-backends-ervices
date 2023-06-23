package com.soldincrease.GymServices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HeaderDto {
  private    String id ;
  private   String userName ;
  private   String email ;
}

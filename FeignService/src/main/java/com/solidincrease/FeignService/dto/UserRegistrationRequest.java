package com.solidincrease.FeignService.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationRequest {
 String email;
  String password;


}

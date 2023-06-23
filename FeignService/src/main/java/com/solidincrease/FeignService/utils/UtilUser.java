package com.solidincrease.FeignService.utils;

import com.soldincrease.FeignServices.dto.UserDto;
import com.soldincrease.FeignServices.entity.Users;

public class UtilUser {
    public static UserDto UserToDto(Users user){
       return UserDto.builder()
                .user_id(user.getUser_id())
              
                .build();

    }
}

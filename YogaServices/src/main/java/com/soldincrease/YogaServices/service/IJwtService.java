package com.soldincrease.YogaServices.service;


import com.soldincrease.YogaServices.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

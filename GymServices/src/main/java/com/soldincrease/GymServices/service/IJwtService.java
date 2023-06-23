package com.soldincrease.GymServices.service;


import com.soldincrease.GymServices.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

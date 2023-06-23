package com.soldincrease.DefaultDataServices.service;

import com.soldincrease.DefaultDataServices.dto.HeaderDto;


public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

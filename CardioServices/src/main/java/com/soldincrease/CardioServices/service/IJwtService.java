package com.soldincrease.CardioServices.service;

import com.soldincrease.CardioServices.dto.HeaderDto;


public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

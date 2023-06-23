package com.solidincrease.authservice.service;


import com.solidincrease.authservice.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

package com.soldincrease.KettleBellServices.service;


import com.soldincrease.KettleBellServices.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

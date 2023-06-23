package com.soldincrease.FeignServices.service;

import com.soldincrease.FeignServices.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

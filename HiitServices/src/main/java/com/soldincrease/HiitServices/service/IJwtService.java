package com.soldincrease.HiitServices.service;


import com.soldincrease.HiitServices.dto.HeaderDto;

public interface IJwtService {

    public HeaderDto headerDeconstruct(String token);
}

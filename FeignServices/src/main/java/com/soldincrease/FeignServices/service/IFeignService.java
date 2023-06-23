package com.soldincrease.FeignServices.service;

import com.soldincrease.FeignServices.dto.HeaderDto;

public interface IFeignService {

    public HeaderDto headerDeconstruct(String token);
}

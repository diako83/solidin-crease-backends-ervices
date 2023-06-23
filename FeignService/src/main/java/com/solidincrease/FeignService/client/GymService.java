package com.solidincrease.FeignService.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "GYM-SERVICE/api/v1/gym")
public interface GymService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("Gym Service is not available",
                "UNAVAILABLE",
                500);
    }
}

package com.soldincrease.FeignServices.external.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "CARDIO-SERVICE/api/v1/cardio")
public interface CardioService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("Cardio Service is not available",
                "UNAVAILABLE",
                500);
    }
}

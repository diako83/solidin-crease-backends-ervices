package com.soldincrease.FeignServices.external.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "YOGA-SERVICE/api/v1/yoga")
public interface YogaService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("Yoga Service is not available",
                "UNAVAILABLE",
                500);
    }
}

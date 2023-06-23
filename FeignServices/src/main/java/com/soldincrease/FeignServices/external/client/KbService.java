package com.soldincrease.FeignServices.external.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "KETTLEBELL-SERVICES/api/v1/kb")
public interface KbService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("KETTLEBELL Service is not available",
                "UNAVAILABLE",
                500);
    }
}

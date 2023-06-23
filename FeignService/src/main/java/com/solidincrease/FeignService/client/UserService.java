package com.solidincrease.FeignService.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "USERS-SERVICE/api/v1/user")
public interface UserService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("User Service is not available",
                "UNAVAILABLE",
                500);
    }
}

package com.solidincrease.FeignService.client;

import com.soldincrease.FeignServices.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient (name = "HIIT_SERVICE/api/v1/hiit")
public interface HiitService {

    default ResponseEntity<Long> fallback(Exception e) {
        throw new CustomException("Hiit Service is not available",
                "UNAVAILABLE",
                500);
    }
}

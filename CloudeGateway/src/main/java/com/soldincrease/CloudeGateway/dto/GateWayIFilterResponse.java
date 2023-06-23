package com.soldincrease.CloudeGateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GateWayIFilterResponse {

    public GatewayFilter data =null;
    public String response = null;
}

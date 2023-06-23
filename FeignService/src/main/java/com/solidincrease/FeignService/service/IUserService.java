package com.solidincrease.FeignService.service;

import com.soldincrease.FeignServices.dto.Responce;
import com.soldincrease.FeignServices.dto.UserRegistrationRequest;

import java.util.Optional;

public interface IUserService {

    Optional<Responce> registerCustomer(UserRegistrationRequest userRegister);
}

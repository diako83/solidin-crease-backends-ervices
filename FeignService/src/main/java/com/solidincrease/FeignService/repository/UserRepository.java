package com.solidincrease.FeignService.repository;

import com.soldincrease.FeignServices.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
    boolean existsUsersByEmail(String email);
}

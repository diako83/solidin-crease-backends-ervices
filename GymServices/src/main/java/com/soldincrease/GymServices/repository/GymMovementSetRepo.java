package com.soldincrease.GymServices.repository;

import com.soldincrease.GymServices.entity.GymMovementSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymMovementSetRepo extends JpaRepository<GymMovementSetEntity,String> {
}

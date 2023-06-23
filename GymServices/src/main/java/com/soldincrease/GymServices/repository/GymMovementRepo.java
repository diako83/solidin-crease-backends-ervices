package com.soldincrease.GymServices.repository;

import com.soldincrease.GymServices.entity.GymMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymMovementRepo extends JpaRepository<GymMovementEntity,String> {
}

package com.soldincrease.GymServices.repository;

import com.soldincrease.GymServices.entity.GymWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<GymWorkoutEntity, String> {
   List<GymWorkoutEntity> findAllByUserId(String userId);
}

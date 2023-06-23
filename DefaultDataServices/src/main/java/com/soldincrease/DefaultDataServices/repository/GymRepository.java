package com.soldincrease.DefaultDataServices.repository;

import com.soldincrease.DefaultDataServices.entity.GymEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<GymEntity, String> {
}

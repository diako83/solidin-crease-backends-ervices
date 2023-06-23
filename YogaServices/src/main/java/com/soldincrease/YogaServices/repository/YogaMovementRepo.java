package com.soldincrease.YogaServices.repository;


import com.soldincrease.YogaServices.entity.YogaMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YogaMovementRepo extends JpaRepository<YogaMovementEntity,String> {
}

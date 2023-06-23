package com.soldincrease.KettleBellServices.repository;


import com.soldincrease.KettleBellServices.entity.KbMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KbMovementRepo extends JpaRepository<KbMovementEntity,String> {
}

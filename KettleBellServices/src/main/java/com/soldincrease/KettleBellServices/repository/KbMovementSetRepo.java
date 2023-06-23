package com.soldincrease.KettleBellServices.repository;


import com.soldincrease.KettleBellServices.entity.KbMovementSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KbMovementSetRepo extends JpaRepository<KbMovementSetEntity,String> {
}

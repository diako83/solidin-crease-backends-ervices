package com.soldincrease.SharedServices.repository.CardioRepository;

import com.soldincrease.SharedServices.entity.CardioEntitys.CardioMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardioMovementRepo extends JpaRepository<CardioMovementEntity,String> {
}

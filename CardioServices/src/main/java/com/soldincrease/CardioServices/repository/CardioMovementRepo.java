package com.soldincrease.CardioServices.repository;

import com.soldincrease.CardioServices.entity.CardioMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CardioMovementRepo extends JpaRepository<CardioMovementEntity,String> {
}

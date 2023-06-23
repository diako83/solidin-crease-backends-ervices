package com.soldincrease.CardioServices.repository;



import com.soldincrease.CardioServices.entity.CardioMovementSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardioMovementSetRepo extends JpaRepository<CardioMovementSetEntity,String> {
}

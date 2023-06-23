package com.soldincrease.CardioServices.repository;



import com.soldincrease.CardioServices.entity.CardioWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardioWorkoutRepo extends JpaRepository<CardioWorkoutEntity,String> {
    List<CardioWorkoutEntity> findAllByUserId(String userId);
}

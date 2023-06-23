package com.soldincrease.SharedServices.repository.CardioRepository;


import com.soldincrease.SharedServices.entity.CardioEntitys.CardioTimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardioTimerRepo extends JpaRepository<CardioTimerEntity,String> {
}

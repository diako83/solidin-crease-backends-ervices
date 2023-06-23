package com.soldincrease.CardioServices.repository;



import com.soldincrease.CardioServices.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepo  extends JpaRepository<TimerEntity,String> {
}

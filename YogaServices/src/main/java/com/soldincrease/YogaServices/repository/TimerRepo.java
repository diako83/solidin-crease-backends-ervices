package com.soldincrease.YogaServices.repository;


import com.soldincrease.YogaServices.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepo  extends JpaRepository<TimerEntity,String> {
}

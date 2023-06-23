package com.soldincrease.KettleBellServices.repository;


import com.soldincrease.KettleBellServices.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepo  extends JpaRepository<TimerEntity,String> {
}

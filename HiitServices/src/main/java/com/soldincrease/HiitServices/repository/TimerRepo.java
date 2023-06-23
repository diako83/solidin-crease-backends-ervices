package com.soldincrease.HiitServices.repository;

import com.soldincrease.HiitServices.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimerRepo  extends JpaRepository<TimerEntity,String> {
}

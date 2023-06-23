package com.soldincrease.HiitServices.repository;

import com.soldincrease.HiitServices.entity.HiitWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HiitWorkoutRepo extends JpaRepository<HiitWorkoutEntity,String> {
    List<HiitWorkoutEntity> findAllByUserId(String userId);
}

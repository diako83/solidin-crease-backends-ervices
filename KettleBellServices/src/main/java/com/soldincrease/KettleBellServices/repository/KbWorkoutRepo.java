package com.soldincrease.KettleBellServices.repository;


import com.soldincrease.KettleBellServices.entity.KbWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KbWorkoutRepo extends JpaRepository<KbWorkoutEntity,String> {
    List<KbWorkoutEntity> findAllByUserId(String userId);

}

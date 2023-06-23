package com.soldincrease.YogaServices.repository;


import com.soldincrease.YogaServices.entity.YogaWorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YogaWorkoutRepo extends JpaRepository<YogaWorkoutEntity,String> {
    List<YogaWorkoutEntity> findAllByUserId(String userId);

}

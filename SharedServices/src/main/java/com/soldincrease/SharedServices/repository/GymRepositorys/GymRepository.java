package com.soldincrease.SharedServices.repository.GymRepositorys;

import com.soldincrease.SharedServices.entity.GymEntitys.GymWorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<GymWorkoutEntity, String> {
    Page<GymWorkoutEntity> findAll(Pageable pageable);
}

package com.soldincrease.SharedServices.repository.HiitRepositorya;


import com.soldincrease.SharedServices.entity.CardioEntitys.CardioWorkoutEntity;
import com.soldincrease.SharedServices.entity.HiitEntitys.HiitWorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiitWorkoutRepo extends JpaRepository<HiitWorkoutEntity,String> {
    Page<HiitWorkoutEntity> findAll(Pageable pageable);
}

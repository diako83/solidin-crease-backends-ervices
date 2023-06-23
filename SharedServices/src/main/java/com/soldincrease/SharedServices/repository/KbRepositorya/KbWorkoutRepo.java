package com.soldincrease.SharedServices.repository.KbRepositorya;


import com.soldincrease.SharedServices.entity.CardioEntitys.CardioWorkoutEntity;
import com.soldincrease.SharedServices.entity.KbEntitys.KbWorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KbWorkoutRepo extends JpaRepository<KbWorkoutEntity,String> {

    Page<KbWorkoutEntity> findAll(Pageable pageable);
}

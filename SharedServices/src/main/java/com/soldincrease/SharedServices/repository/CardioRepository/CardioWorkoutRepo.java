package com.soldincrease.SharedServices.repository.CardioRepository;


import com.soldincrease.SharedServices.entity.CardioEntitys.CardioWorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardioWorkoutRepo extends JpaRepository<CardioWorkoutEntity,String> {

    Page<CardioWorkoutEntity> findAll(Pageable pageable);


}

package com.soldincrease.SharedServices.repository.GymRepositorys;


import com.soldincrease.SharedServices.entity.GymEntitys.GymMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymMovementRepo extends JpaRepository<GymMovementEntity,String> {
}

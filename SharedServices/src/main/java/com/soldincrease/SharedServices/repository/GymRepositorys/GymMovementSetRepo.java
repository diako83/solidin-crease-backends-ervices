package com.soldincrease.SharedServices.repository.GymRepositorys;


import com.soldincrease.SharedServices.entity.GymEntitys.GymMovementSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymMovementSetRepo extends JpaRepository<GymMovementSetEntity,String> {
}

package com.soldincrease.HiitServices.repository;

import com.soldincrease.HiitServices.entity.HiitMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiitMovementRepo  extends JpaRepository<HiitMovementEntity,String> {
}

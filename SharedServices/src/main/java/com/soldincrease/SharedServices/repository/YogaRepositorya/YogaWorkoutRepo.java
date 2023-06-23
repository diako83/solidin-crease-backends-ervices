package com.soldincrease.SharedServices.repository.YogaRepositorya;


import com.soldincrease.SharedServices.entity.YogaEntitys.YogaWorkoutEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface YogaWorkoutRepo extends JpaRepository<YogaWorkoutEntity,String> {

    Page<YogaWorkoutEntity> findAll(Pageable pageable);

}

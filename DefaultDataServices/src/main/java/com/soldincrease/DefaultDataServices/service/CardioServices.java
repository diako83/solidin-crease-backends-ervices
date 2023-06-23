package com.soldincrease.DefaultDataServices.service;

import com.soldincrease.DefaultDataServices.dto.CardioDtos.RequestCardio;
import com.soldincrease.DefaultDataServices.entity.CardioEntity;
import com.soldincrease.DefaultDataServices.interfaces.ICardioServices;
import com.soldincrease.DefaultDataServices.repository.CardioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
public class CardioServices implements ICardioServices {

    private final CardioRepository cardioRepository;

    public Stream<String> getLisOfCardioExercises (){
        List<CardioEntity> cardio = cardioRepository.findAll();

     return        cardio.stream().map(i ->i.getExercise());

    }

    public String setCardioExercises(RequestCardio exercise) {
        UUID uuid = UUID.randomUUID();
        CardioEntity entity = CardioEntity.builder()
                .id(uuid.toString())
                .exercise(exercise.exercise)
                .build();

        return cardioRepository.save(entity).getExercise();
    }
}

package com.soldincrease.DefaultDataServices.interfaces;

import com.soldincrease.DefaultDataServices.dto.CardioDtos.RequestCardio;

import java.util.stream.Stream;

public interface ICardioServices {
    Stream<String> getLisOfCardioExercises ();
    String setCardioExercises(RequestCardio exercise);
}

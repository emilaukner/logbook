package com.test.logbook.service;

import com.test.logbook.model.Exercise;
import com.test.logbook.model.Workout;
import com.test.logbook.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
  private final ExerciseRepository exerciseRepository;

  @Autowired
  public ExerciseService(ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;
  }

  public List<Exercise> getExercises() {
    return exerciseRepository.findAll();
  }

  public Exercise getExercise(Long id) {
    boolean exists = exerciseRepository.existsById(id);
    if (exists) {
      return exerciseRepository.findById(id).get();
    } else {
      throw new IllegalStateException("No exercise with Id: " + id);
    }
  }
}

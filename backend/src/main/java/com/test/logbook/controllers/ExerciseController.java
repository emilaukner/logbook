package com.test.logbook.controllers;

import com.test.logbook.model.Exercise;
import com.test.logbook.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/exercise")
@CrossOrigin
public class ExerciseController {
  private final ExerciseService exerciseService;

  @Autowired
  public ExerciseController(ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @GetMapping
  public List<Exercise> getExercises() {
    return exerciseService.getExercises();
  }

  @GetMapping(path="{exerciseId}")
  public Exercise getExercise(@PathVariable("exerciseId") Long id) {
    return exerciseService.getExercise(id);
  }
}

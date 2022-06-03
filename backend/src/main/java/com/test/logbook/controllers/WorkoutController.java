package com.test.logbook.controllers;

import com.test.logbook.model.User;
import com.test.logbook.model.Exercise;
import com.test.logbook.model.Workout;
import com.test.logbook.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path="api/workout")
@CrossOrigin
public class WorkoutController {

  private final WorkoutService service;

  @Autowired
  public WorkoutController(WorkoutService service) {
    this.service = service;
  }

  @GetMapping
  public List<Workout> getWorkouts() {
    return service.getWorkouts();
  }

  @GetMapping(path="/ids")
  public List<Long> getWorkoutIds() {
    return service.getIds();
  }

  @GetMapping(path = "{workoutId}")
  public Workout getWorkout(@PathVariable("workoutId") Long id) {
    return service.getWorkout(id);
  }

  @PostMapping
  public Long createWorkout(@RequestParam String name, @RequestParam String userEmail, @RequestParam String userName) {
    return service.createWorkout(name, userEmail, userName);
  }

  @PutMapping(path = "{workoutId}")
  public void addExercise(@PathVariable("workoutId") Long workoutId,
                          String name,
                          int sets,
                          int repsPerSet,
                          double weight,
                          int restTime) {
    service.addExercise(workoutId, name,sets,repsPerSet,weight,restTime);
  }

  @DeleteMapping(path = "{workoutId}/{exerciseId}")
  public void removeExercise(@PathVariable("workoutId") Long workoutId,
                             @PathVariable("exerciseId") Long exerciseId) {
    service.removeExercise(workoutId, exerciseId);
  }
}

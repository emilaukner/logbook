package com.test.logbook.service;

import com.test.logbook.model.AppUser;
import com.test.logbook.model.Exercise;
import com.test.logbook.model.Workout;
import com.test.logbook.repository.ExerciseRepository;
import com.test.logbook.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutService {

  private final WorkoutRepository workoutRepository;

  @Autowired
  public WorkoutService(WorkoutRepository workoutRepository) {
    this.workoutRepository = workoutRepository;
  }

  public List<Workout> getWorkouts() {
      return workoutRepository.findAll();
    }


  public Workout getWorkout(Long id) {
    boolean exists = workoutRepository.existsById(id);
    if (exists) {
      Workout workout = workoutRepository.getWorkout(id);
      System.out.println(workout);
      return workout;
    } else {
      throw new IllegalStateException("No workout with Id: " + id);
    }
  }

  public void createWorkout(String name, AppUser createdBy) {
    workoutRepository.save(new Workout(name, createdBy));
  }

  public void createWorkout(String name, List<Exercise> exerciseList, AppUser createdBy) {
    workoutRepository.save(new Workout(name, exerciseList, createdBy));
  }

  public void addExercise(Long workoutId,
                          String name,
                          int sets,
                          int repsPerSet,
                          double weight,
                          int restTime) {
    boolean exists = workoutRepository.existsById(workoutId);
    if (exists) {
      Workout temp = workoutRepository.findById(workoutId).get();
      Exercise exercise = new Exercise(name,sets,repsPerSet,weight,restTime);
      temp.addExercise(exercise);
      workoutRepository.save(temp);
    } else {
      throw new IllegalStateException("No workout with Id: " + workoutId);
    }
  }

  public void removeExercise(Long workoutId, Long exerciseId) {
    boolean exists = workoutRepository.existsById(workoutId);
    if (exists) {
      Workout workout = workoutRepository.findById(workoutId).get();
      workout.removeExercise(exerciseId);
      workoutRepository.save(workout);
    } else {
      throw new IllegalStateException("No workout with Id: " + workoutId);
    }
  }

  //TODO REMOVE WORKOUT, must remove association with AppUser
}

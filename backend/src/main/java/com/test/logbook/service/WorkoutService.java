package com.test.logbook.service;

import com.test.logbook.model.User;
import com.test.logbook.model.Exercise;
import com.test.logbook.model.Workout;
import com.test.logbook.repository.UserRepository;
import com.test.logbook.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

  private final WorkoutRepository workoutRepository;
  private final UserRepository userRepository;

  @Autowired
  public WorkoutService(WorkoutRepository workoutRepository, UserRepository userRepository) {
    this.workoutRepository = workoutRepository;
    this.userRepository = userRepository;
  }

  public List<Workout> getWorkouts() {
      return workoutRepository.findAll();
    }


  public Workout getWorkout(Long id) {
    boolean exists = workoutRepository.existsById(id);
    if (exists) {
      return workoutRepository.getWorkout(id);
    } else {
      throw new IllegalStateException("No workout with Id: " + id);
    }
  }

  public Long createWorkout(String name, String userEmail, String userName) {
    Optional<User> exists = userRepository.findUserByEmail(userEmail);
    User createdBy;
    if (exists.isPresent()) {
      createdBy = userRepository.findUserByEmail(userEmail).get();
    } else {
      createdBy = new User(userEmail, userName);
      System.out.println(createdBy.getEmail());
      userRepository.save(createdBy);
    }
    Workout temp = new Workout(name, createdBy);
    temp.addExercise(new Exercise());
    workoutRepository.save(temp);
    return temp.getId();
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

  public List<Long> getIds() {
    return workoutRepository.getIds();
  }

  //TODO REMOVE WORKOUT, must remove association with AppUser
}

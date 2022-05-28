package com.test.logbook.repository;

import com.test.logbook.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
  @Query(value = "SELECT w FROM Workout w join Exercise e on w.id = e.workout.id WHERE w.id=?1")
  Workout getWorkout(Long workoutId);
}

package com.test.logbook.repository;

import com.test.logbook.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
  @Query(value = "SELECT w FROM workout w join Exercise e on w.id = e.workout.id WHERE w.id=?1")
  Workout getWorkout(Long workoutId);

  @Query(value = "Select w.id from workout w")
  List<Long> getIds();

  //@Query(value="INSERT INTO app_user_workouts (app_user_email, workouts_id SELECT au.email, w.id FROM app_user au, workout w")
  //void save();

//  @Query(value = "SELECT w from Workout w join app_user u on w.createdBy = u")

}

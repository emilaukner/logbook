package com.test.logbook;

import com.test.logbook.model.Exercise;
import com.test.logbook.model.User;
import com.test.logbook.model.Workout;
import com.test.logbook.repository.ExerciseRepository;
import com.test.logbook.repository.UserRepository;
import com.test.logbook.repository.WorkoutRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class LogbookConfig {
  @Bean
  CommandLineRunner commandLineRunner(WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository, UserRepository userRepository) {
    return args -> {
      User appUser = new User("emil@test.com", "Emil");

      Exercise benchpress = new Exercise("Bench Press", 5, 5, 100, 120);
      Exercise deadlift = new Exercise("Deadlift", 5, 5, 150, 120);


      Workout Chest = new Workout("Chest", appUser);
      Chest.addExercise(benchpress);
      Workout Back = new Workout( "Back", appUser);
      Back.addExercise(deadlift);

      workoutRepository.saveAll(List.of(Chest,Back));
    };
  }
}
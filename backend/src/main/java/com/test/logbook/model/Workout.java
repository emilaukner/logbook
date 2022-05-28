package com.test.logbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Workout")
@Table
public class Workout {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne
  @JsonManagedReference
  @JoinColumn(name = "created_by_email")
  private AppUser createdBy;
  @OneToMany(cascade = {CascadeType.ALL})
  @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
  private List<Exercise> exerciseList = new ArrayList<>();


  public Workout() {}

  @Override
  public String toString() {
    return "Workout{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", createdBy=" + createdBy +
          ", exerciseList=" + exerciseList +
          '}';
  }

  public Workout(Long id, String name, List<Exercise> exerciseList, AppUser createdBy) {
    this.id = id;
    this.name = name;
    this.exerciseList = exerciseList;
    this.createdBy = createdBy;
  }

  public Workout(String name, List<Exercise> exerciseList, AppUser createdBy) {
    this.name = name;
    this.exerciseList = exerciseList;
    this.createdBy = createdBy;
  }

  public Workout(Long id, String name, AppUser createdBy) {
    this.id = id;
    this.name = name;
    this.createdBy = createdBy;
  }

  public Workout(String name, AppUser createdBy) {
    this.name = name;
    this.createdBy = createdBy;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AppUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(AppUser createdBy) {
    this.createdBy = createdBy;
  }

  public List<Exercise> getExerciseList() {
    return exerciseList;
  }

  public void setExerciseList(List<Exercise> exerciseList) {
    this.exerciseList = exerciseList;
  }

  public void addExercise(Exercise exercise) {
    if (!exerciseList.contains(exercise)) {
      if (exercise.getWorkout() == null || !exercise.getWorkout().getId().equals(id)) {
        exercise.setWorkout(this);
      }
      exerciseList.add(exercise);
    } else {
      throw new IllegalStateException("Exercise already in workout");
    }
  }

  public void removeExercise(Long exerciseId) {
    for (Exercise e : exerciseList) {
      if (e.getId().equals(exerciseId)) {
        exerciseList.remove(e);
        e.setWorkout(null);
        return;
      }
    }
    throw new IllegalStateException("No exercise with id:" + exerciseId + "found");
  }
}

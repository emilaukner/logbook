package com.test.logbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "workout")
@Table
public class Workout {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @ManyToOne(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinColumn(name = "app_user_email")
  private User createdBy;
  @OneToMany(cascade = {CascadeType.ALL})
  @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
  private Collection<Exercise> exerciseList = new ArrayList<>();
  private LocalDate dateCreated = LocalDate.now();

  public User getAppUser() {
    return createdBy;
  }

  public void setAppUser(User appUser) {
    this.createdBy = appUser;
  }


  public Workout() {}

  public Workout(Long id, String name, Collection<Exercise> exerciseList, User createdBy) {
    this.id = id;
    this.name = name;
    this.exerciseList = exerciseList;
    this.createdBy = createdBy;
  }

  public Workout(String name, Collection<Exercise> exerciseList, User createdBy) {
    this.name = name;
    this.exerciseList = exerciseList;
    this.createdBy = createdBy;
  }

  public Workout(Long id, String name, User createdBy) {
    this.id = id;
    this.name = name;
    this.createdBy = createdBy;
  }

  public Workout(String name, User createdBy) {
    this.name = name;
    this.createdBy = createdBy;
  }

  @Override
  public String toString() {
    return "Workout{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", createdBy=" + createdBy +
          ", exerciseList=" + exerciseList +
          ", dateCreated=" + dateCreated +
          '}';
  }

  public LocalDate getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDate dateCreated) {
    this.dateCreated = dateCreated;
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

  public User getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(User createdBy) {
    this.createdBy = createdBy;
  }

  public Collection<Exercise> getExerciseList() {
    return exerciseList;
  }

  public void setExerciseList(Collection<Exercise> exerciseList) {
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

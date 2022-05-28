package com.test.logbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class Exercise {
  @ManyToOne
  @JoinColumn(name = "workout_id", referencedColumnName="id", foreignKey = @ForeignKey(name = "workout_id"))
  @JsonBackReference
  private Workout workout;
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private int sets;
  private int repsPerSet;
  private double weight;
  private int restTime;

  public Exercise() {}

  public Exercise(Long id, String name, int sets, int repsPerSet, double weight, int restTime) {
    this.id = id;
    this.name = name;
    this.sets = sets;
    this.repsPerSet = repsPerSet;
    this.weight = weight;
    this.restTime = restTime;
  }

  public Exercise(String name, int sets, int repsPerSet, double weight, int restTime) {
    this.name = name;
    this.sets = sets;
    this.repsPerSet = repsPerSet;
    this.weight = weight;
    this.restTime = restTime;
  }

  public Workout getWorkout() {
    return workout;
  }

  public void setWorkout(Workout workout) {
    this.workout = workout;
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

  public int getSets() {
    return sets;
  }

  public void setSets(int sets) {
    this.sets = sets;
  }

  public int getRepsPerSet() {
    return repsPerSet;
  }

  public void setRepsPerSet(int repsPerSet) {
    this.repsPerSet = repsPerSet;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getRestTime() {
    return restTime;
  }

  public void setRestTime(int restTime) {
    this.restTime = restTime;
  }
}

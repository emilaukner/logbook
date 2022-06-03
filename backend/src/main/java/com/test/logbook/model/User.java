package com.test.logbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="app_user")
@Table
public class User {
  @Id
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  private String name;
  @OneToMany(mappedBy="createdBy")
  private List<Workout> workouts = new ArrayList<>();

  public User(String email) {
    this.email = email;
  }

  public User(String email, String name) {
    this.email = email;
    this.name = name;
  }

  public User() {

  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

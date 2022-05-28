package com.test.logbook.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="appUser")
@Table
public class AppUser {
  @Id
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  private String name;
  @OneToMany
  @JsonBackReference
  private List<Workout> workouts = new ArrayList<>();

  public AppUser(String email) {
    this.email = email;
  }

  public AppUser(String email, String name) {
    this.email = email;
    this.name = name;
  }

  public AppUser() {

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

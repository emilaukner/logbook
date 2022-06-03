package com.test.logbook.controllers;

import com.test.logbook.model.User;
import com.test.logbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
@CrossOrigin
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getStudents() {
    return userService.getUsers();
  }

  @PostMapping
  public void createUser(@RequestBody User user) {
    userService.createUser(user);
  }

  @GetMapping(path = "{user_email}")
  public User getUser(@PathVariable("user_email") String email) {
    return userService.getUser(email);
  }
}

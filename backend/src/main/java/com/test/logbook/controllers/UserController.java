package com.test.logbook.controllers;

import com.test.logbook.model.AppUser;
import com.test.logbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/user")
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<AppUser> getStudents() {
    return userService.getUsers();
  }

  @GetMapping(path = "{user_email}")
  public AppUser getUser(@PathVariable("user_email") String email) {
    return userService.getUser(email);
  }
}

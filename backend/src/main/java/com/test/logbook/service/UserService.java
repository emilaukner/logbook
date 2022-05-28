package com.test.logbook.service;

import com.test.logbook.model.AppUser;
import com.test.logbook.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  private final AppUserRepository userRepository;

  @Autowired
  public UserService(AppUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<AppUser> getUsers() {
    return userRepository.findAll();
  }

  public AppUser getUser(String email) {
    return userRepository.findAppUserByEmail(email).orElseThrow(() -> new IllegalStateException("No such user"));
  }
}

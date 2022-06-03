package com.test.logbook.service;

import com.test.logbook.model.User;
import com.test.logbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getUsers() {
    return userRepository.findAll();
  }

  public User getUser(String email) {
    return userRepository.findUserByEmail(email).orElseThrow(() -> new IllegalStateException("No such user"));
  }

/*  public void createUser(String userEmail, String userName) {
    AppUser user = new AppUser(userEmail);
    userRepository.save(user);
  }*/

  public void createUser(User appUser) {
    Optional<User> userByEmail = userRepository.findUserByEmail(appUser.getEmail());
    if (userByEmail.isPresent()) {
      throw new IllegalStateException("email taken");
    }
    userRepository.save(appUser);
  }
}

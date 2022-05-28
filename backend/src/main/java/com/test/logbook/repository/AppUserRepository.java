package com.test.logbook.repository;

import com.test.logbook.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
  @Query(value = "SELECT u FROM appUser u where u.email=?1")
  Optional<AppUser> findAppUserByEmail(String email);
}

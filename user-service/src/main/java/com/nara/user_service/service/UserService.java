package com.nara.user_service.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import com.nara.user_service.repo.UserRepo;

@Service
public class UserService {

  private final UserRepo userRepo;

  public UserService(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  public void deleteUserById(Integer id) {
    if (!userRepo.existsById(id)) {
      throw new RuntimeException("That user doesnt exists");
    }
    userRepo.deleteById(id);
  }

  public void addUser(User user) {
    userRepo.save(user);
  }

}

package com.nara.user_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nara.user_service.model.UserProfile;
import com.nara.user_service.repo.UserProfileRepo;

@Service
public class UserProfileService {

  private final UserProfileRepo userProfileRepo;

  public UserProfileService(UserProfileRepo userProfileRepo) {
    this.userProfileRepo = userProfileRepo;
  }

  public List<UserProfile> getAllProfile() {
    return userProfileRepo.findAll();
  }

  public void deleteById(Integer id) {
    if (!userProfileRepo.existsById(id)) {
      throw new RuntimeException("User of that id doesnt exist in the database");
    }
    userProfileRepo.deleteById(id);
  }

  public void addUserProfile(UserProfile userProfile) {
    userProfileRepo.save(userProfile);
  }

}

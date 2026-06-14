package com.nara.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nara.user_service.model.UserProfile;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {

  public UserProfileRepo findByUsername(String username);

}

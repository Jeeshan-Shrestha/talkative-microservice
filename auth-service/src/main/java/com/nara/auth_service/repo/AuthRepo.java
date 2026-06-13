package com.nara.auth_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nara.auth_service.model.AuthObject;

@Repository
public interface AuthRepo extends JpaRepository<AuthObject, Integer> {

  public AuthObject findByUsername(String username);

}

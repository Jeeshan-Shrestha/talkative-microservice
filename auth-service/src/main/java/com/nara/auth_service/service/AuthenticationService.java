package com.nara.auth_service.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nara.auth_service.jwt.JwtUtils;
import com.nara.auth_service.model.AuthObject;
import com.nara.auth_service.repo.AuthRepo;

@Service
public class AuthenticationService {

  private final AuthRepo authRepo;
  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;

  public AuthenticationService(AuthRepo authRepo,
      AuthenticationManager authenticationManager,
      JwtUtils jwtUtils) {
    this.authRepo = authRepo;
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
  }

  public void register(AuthObject authObject) {

    AuthObject user = authRepo.findByUsername(authObject.getUsername());
    if (user != null) {
      throw new RuntimeException("User with that name already exists in the database");
    }

    authRepo.save(authObject);

  }

  public String login(AuthObject authObject) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(authObject.getUsername(), authObject.getPassword()));
    if (authentication.isAuthenticated()) {

      return jwtUtils.generateToken(authObject);

    }
    throw new BadCredentialsException("Wrong Credentials");
  }

}

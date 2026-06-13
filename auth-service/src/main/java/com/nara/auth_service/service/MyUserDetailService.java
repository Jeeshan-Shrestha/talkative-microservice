package com.nara.auth_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nara.auth_service.model.AuthObject;
import com.nara.auth_service.model.AuthObject;
import com.nara.auth_service.repo.AuthRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

  @Autowired
  private AuthRepo authRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    AuthObject dbUser = authRepo.findByUsername(username);
    if (dbUser == null) {
      throw new UsernameNotFoundException("Username not found in the database");
    }

    return dbUser;
  }

}

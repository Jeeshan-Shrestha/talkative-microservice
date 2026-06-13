package com.nara.auth_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nara.auth_service.model.AuthObject;
import com.nara.auth_service.service.AuthenticationService;

@RestController
@RequestMapping
public class AuthController {

  private final AuthenticationService authenticationService;

  public AuthController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/register")
  public String register(@RequestBody AuthObject authObject) {

    authenticationService.register(authObject);
    return "User Registered";
  }

  @PostMapping("/login")
  public String login(@RequestBody AuthObject authObject) {
    String token = authenticationService.login(authObject);
    return token;
  }

}

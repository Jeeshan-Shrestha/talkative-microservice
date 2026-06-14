package com.nara.user_service.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nara.user_service.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("/add")
  public void addUser(@RequestBody User user) {
    userService.addUser(user);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteUserById(@PathVariable Integer id) {
    userService.deleteUserById(id);
    return "successfully deleted";
  }

}

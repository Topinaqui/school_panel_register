package com.faiton.school_panel_register.controllers;

import com.faiton.school_panel_register.entities.User;
import com.faiton.school_panel_register.services.RegisterService;
import com.faiton.school_panel_register.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {

  @Autowired
  private RegisterService registerService;

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@RequestBody User user) {

    // User savedUser = userService.;
    return user;
  }

  @GetMapping("/confirm-registration/:{token}")
  public void confirmRegistration(@PathVariable String token) {

    registerService.confirmRegistration(token);
  }

}

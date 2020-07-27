package com.faiton.school_panel_register.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;

import com.faiton.school_panel_register.entities.SystemInfo;
import com.faiton.school_panel_register.entities.User;
import com.faiton.school_panel_register.services.EmailSenderService;
import com.faiton.school_panel_register.services.RegisterService;
import com.faiton.school_panel_register.services.UserService;

@RestController
public class RegisterController {

  @Autowired
  private SystemInfo info;

  @Autowired
  private EmailSenderService emailSender;

  @Autowired
  private RegisterService registerService;

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public User register(@RequestBody User user) {
    System.out.println("User password:");
    System.out.println(user.getPassword());

    User registredUser = registerService.registerUser(user);

    return registredUser;
  }

  // @GetMapping("/confirm-registration/:{token}")
  // public void confirmRegistration(@PathVariable String token) {

  // registerService.confirmRegistration(token);
  // }

  @PostMapping("/info")
  public String info() {
    return "System Info: " + info.getVersion() + " - " + info.getVersionName();
  }

  @GetMapping("/hello")
  public String sendHelloWorld() {
    String okMessage = "OK! now verify your in box.";

    final SimpleMailMessage email = new SimpleMailMessage();
    email.setTo("aionprofile@hotmail.com");
    email.setSubject("Hello World!");
    email.setFrom("faiton@live.com");

    String message = "Hello World!";

    email.setText(message);

    try {

      emailSender.sendEmail(email);

      return okMessage;
    } catch (Exception e) {

      // System.out.println(e.getStackTrace());
      System.out.println(e.getMessage());

      return e.getMessage() + " - " + info.getVersion();
    }
  }

}

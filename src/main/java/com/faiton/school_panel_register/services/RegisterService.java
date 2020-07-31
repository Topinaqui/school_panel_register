package com.faiton.school_panel_register.services;

import com.faiton.school_panel_register.entities.ConfirmationToken;
import com.faiton.school_panel_register.entities.User;
import com.faiton.school_panel_register.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class RegisterService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ConfirmationTokenService confirmationTokenService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private EmailSenderService emailSenderService;

  public User registerUser(User user) {

    final String password = bCryptPasswordEncoder.encode(user.getPassword());

    user.setPassword(password);

    userRepository.save(user);

    final ConfirmationToken cToken = new ConfirmationToken(user);

    confirmationTokenService.saveConfirmationToken(cToken);

    sendConfirmationMail(user.getEmail(), cToken.getToken());

    return user;
  }

  public Boolean confirmRegistration(String token) {

    ConfirmationToken confToken = confirmationTokenService.findConfirmationToken(token);

    try {
      User user = confToken.getUser();

      System.out.println("user: ");
      System.out.println(user);

      user.setEnabled(true);

      confirmationTokenService.deleteConfirmationToken(confToken.getId());

      userRepository.save(user);

    } catch (Exception e) {

      e.printStackTrace();

      return false;
    }

    return true;
  }

  public void sendConfirmationMail(String userMail, String token) {

    final SimpleMailMessage email = new SimpleMailMessage();
    email.setTo(userMail);
    email.setSubject("School Panel - Confirmation Link");
    email.setFrom("faiton@live.com");

    String message = "Thank you for registering. ";
    message += " Please Click the link below to confirm your account.";
    message += "http://localhost:9010/confirm-registration/" + token;

    email.setText(message);

    // final EmailSenderService emailSenderService = new EmailSenderService();

    emailSenderService.sendEmail(email);
  }
}
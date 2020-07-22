package com.faiton.school_panel_register.services;

import java.util.Optional;

import com.faiton.school_panel_register.entities.ConfirmationToken;
import com.faiton.school_panel_register.entities.User;
import com.faiton.school_panel_register.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EmailSenderService emailSenderService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    final Optional<User> optionalUser = userRepository.findByUsername(username);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new UsernameNotFoundException("User not found!");
    }
  }

  // void registerUser(User user) {

  //   final String encriptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

  //   user.setPassword(encriptedPassword);

  //   final User createdUser = userRepository.save(user);

  //   final ConfirmationToken confirmationToken = new ConfirmationToken(user);

  //   confirmationTokenService.saveConfirmationToken(confirmationToken);

  // }

  // void sendConfirmationMail(String userMail, String token) {

  //   final SimpleMailMessage emailMessage = new SimpleMailMessage();
  //   emailMessage.setTo(userMail);
  //   emailMessage.setSubject("Mail Confirmation Link!");
  //   emailMessage.setFrom("<MAIL>");
  //   emailMessage.setText("Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="+ token);

  //   emailSenderService.sendEmail(emailMessage);
  // }

}
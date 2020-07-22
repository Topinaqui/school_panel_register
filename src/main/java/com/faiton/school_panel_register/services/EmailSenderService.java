package com.faiton.school_panel_register.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class EmailSenderService {
 
  private JavaMailSender javaMailSender;

  @Async
  public void sendEmail(SimpleMailMessage email) {

    javaMailSender.send(email);

  }
}
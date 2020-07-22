package com.faiton.school_panel_register.services;

import java.util.List;

import com.faiton.school_panel_register.entities.ConfirmationToken;
import com.faiton.school_panel_register.repositories.ConfirmationTokenRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {


  private ConfirmationTokenRepository confirmationTokenRepository;

  public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {

    return confirmationTokenRepository.save(confirmationToken);
  }

  public void deleteConfirmationToken(Long id) {

    confirmationTokenRepository.deleteById(id);

  }

  public ConfirmationToken findConfirmationToken(String token) {

   List<ConfirmationToken> list = confirmationTokenRepository.findByConfirmationToken(token);

   if (list.size() > 0) {

     return list.get(0);
   } else {

    return null;
   }
  }
}
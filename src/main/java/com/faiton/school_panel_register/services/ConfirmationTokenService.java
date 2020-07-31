package com.faiton.school_panel_register.services;

import java.util.List;

import com.faiton.school_panel_register.entities.ConfirmationToken;
import com.faiton.school_panel_register.repositories.ConfirmationTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// 11 30141066 - 64  Renan

@Service
public class ConfirmationTokenService {

  @Autowired
  private ConfirmationTokenRepository confirmationTokenRepository;

  public ConfirmationToken saveConfirmationToken(ConfirmationToken confirmationToken) {

    return confirmationTokenRepository.save(confirmationToken);
  }

  public void deleteConfirmationToken(Long id) {

    confirmationTokenRepository.deleteById(id);

  }

  public ConfirmationToken findConfirmationToken(String token) {

    List<ConfirmationToken> list = confirmationTokenRepository.findByToken(token);

    if (list.size() > 0) {

      return list.get(0);
    } else {

      return null;
    }
  }

}
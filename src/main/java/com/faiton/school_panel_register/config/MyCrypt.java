package com.faiton.school_panel_register.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyCrypt implements PasswordEncoder {

  @Override
  public String encode(CharSequence rawPassword) {
    // TODO Auto-generated method stub
    return (String) rawPassword;
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    // TODO Auto-generated method stub
    return true;
  }

}
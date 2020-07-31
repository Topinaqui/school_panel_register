package com.faiton.school_panel_register.config;

import com.faiton.school_panel_register.entities.SystemInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {

  @Bean
  public SystemInfo systemInfo() {

    return new SystemInfo("1.0.0", "Canary");
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {

    return new BCryptPasswordEncoder();
  }

}
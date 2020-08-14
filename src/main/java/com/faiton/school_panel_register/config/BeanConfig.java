package com.faiton.school_panel_register.config;

import com.faiton.school_panel_register.entities.SystemInfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BeanConfig {

  @Bean
  public SystemInfo systemInfo() {

    return new SystemInfo();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {

    return new BCryptPasswordEncoder();
  }

  @Bean
  public AppConfig appConfig() {

    return new AppConfig();
  }

}
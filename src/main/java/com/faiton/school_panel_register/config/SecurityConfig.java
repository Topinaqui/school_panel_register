package com.faiton.school_panel_register.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers(HttpMethod.POST, "/info/**").permitAll()
        .antMatchers(HttpMethod.POST, "/registre/**").permitAll().antMatchers(HttpMethod.GET, "/hello/**").permitAll()
        .and().csrf().disable();
  }

}
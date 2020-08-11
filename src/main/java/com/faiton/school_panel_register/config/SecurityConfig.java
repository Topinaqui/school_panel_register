package com.faiton.school_panel_register.config;

import com.faiton.school_panel_register.filters.UserAuthenticationFilter;
import com.faiton.school_panel_register.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private UserService userService;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {

    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers(HttpMethod.POST, "/info/**").permitAll()
        .antMatchers(HttpMethod.POST, "/registre/**").permitAll().antMatchers(HttpMethod.GET, "/hello/**").permitAll()
        .antMatchers(HttpMethod.GET, "/confirm-registration/**").permitAll().and()
        .addFilter(new UserAuthenticationFilter(authenticationManagerBean())).authorizeRequests()
        .antMatchers(HttpMethod.POST, "/validate").permitAll();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    System.out.println("bcrypt: " + bCryptPasswordEncoder);

    auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
  }

}
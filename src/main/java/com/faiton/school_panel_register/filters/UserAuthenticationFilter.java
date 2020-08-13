package com.faiton.school_panel_register.filters;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.faiton.school_panel_register.config.JWTConfig;
import com.faiton.school_panel_register.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private AuthenticationManager authManager;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  private JWTConfig jwtConfig = new JWTConfig();

  private DaoAuthenticationProvider authenticationProvider;

  /**
   * @param authManager
   */
  public UserAuthenticationFilter(AuthenticationManager authManager) {
    this.authManager = authManager;

    this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/validate", "POST"));
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

    String username = "";
    String password = "";

    try {

      System.out.println("... blue");

      User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

      username = user.getUsername();
      password = user.getPassword();

      // System.out.println(request.getAttributeNames());

      // Map<String, String[]> attrs = request.getParameterMap();

      // Set<String> keys = attrs.keySet();

      // System.out.println(keys);

      // keys.forEach((String key) -> {
      // System.out.println(key);
      // });

      // System.out.println("--------------------------------------------------------");

    } catch (Exception e) {

      e.printStackTrace();
    }

    if (username == null) {
      username = "";
    }

    if (password == null) {
      password = "";
    }

    username = username.trim();
    // $2a$10$kLCItJf5V9r06AlKwbxkmuznvfsrqxpuxIohSs.tXWlGfnrMX1MHa
    System.out.println(username + " - " + password);
    // System.out.println("Password " + bCryptPasswordEncoder.encode(password));

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

    System.out.println("Cred: " + authenticationToken.getCredentials().toString());

    Authentication auth = null;

    try {
      auth = authManager.authenticate(authenticationToken);

      System.out.println("is: " + auth.isAuthenticated());

      return auth;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      return auth;
    }

  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    // super.successfulAuthentication(request, response, chain, authResult);

    String key = "$2a$10$kLCItJf5V9r06AlKwbxkmuznvfsrqxpuxIohSs.tXWlGfnrMX1MHa";

    Long now = System.currentTimeMillis();
    String token = Jwts.builder().setSubject(authResult.getName())
        .claim("authorities", authResult.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList()))
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + (24* 60 * 60 * 1000)))
        .signWith(SignatureAlgorithm.HS512, key.getBytes())
        .compact();

    response.addHeader("Authorization", "Bearer " + token);
  }

}
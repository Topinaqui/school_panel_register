package com.faiton.school_panel_register.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User implements UserDetails {

  private static final long serialVersionUID = 91812214244341405L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;

  private String name;

  private String surname;

  private String email;

  private String password;

  private String role = "USER";

  private ArrayList<String> authorities;

  private Boolean enabled = false;

  private Boolean accountNonLocked = true;

  private Boolean accountNonExpired = true;

  private Boolean credentialsNonExpired = true;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    // final SimpleGrantedAuthority simpleGrantedAuthority = new
    // SimpleGrantedAuthority(role);

    List<SimpleGrantedAuthority> list = new ArrayList<>();

    for (String authority : authorities) {

      list.add(new SimpleGrantedAuthority(authority));

    }

    // return Collections.singletonList(simpleGrantedAuthority);

    return list;
  }

  // @Override
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  // @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !credentialsNonExpired;
  }

  // public boolean isExpired() {
  // return !expired;
  // }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return the surname
   */
  public String getSurname() {
    return surname;
  }

  /**
   * @param surname the surname to set
   */
  public void setSurname(String surname) {
    this.surname = surname;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the role
   */
  public String getRole() {
    return role;
  }

  /**
   * @param role the role to set
   */
  public void setRole(String role) {
    this.role = role;
  }

  /**
   * @return the expired
   */
  public Boolean getExpired() {
    return expired;
  }

  /**
   * @param expired the expired to set
   */
  public void setExpired(Boolean expired) {
    this.expired = expired;
  }

  /**
   * @return the enabled
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}

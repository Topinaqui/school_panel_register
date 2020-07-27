package com.faiton.school_panel_register.entities;

import java.util.Collection;
import java.util.Collections;

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

  private String userRole;

  private Boolean expired;

  private Boolean enabled = false;

  private Boolean locked;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRole);

    return Collections.singletonList(simpleGrantedAuthority);
  }

  @Override
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

  public boolean isAccountNonExpired() {
    return expired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !expired;
  }

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
  * @return the userRole
  */
  public String getUserRole() {
    return userRole;
  }

  /**
  * @param userRole the userRole to set
  */
  public void setUserRole(String userRole) {
    this.userRole = userRole;
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

/**
 * @return the locked
 */
public Boolean getLocked() {
	return locked;
}

/**
 * @param locked the locked to set
 */
public void setLocked(Boolean locked) {
	this.locked = locked;
}

}

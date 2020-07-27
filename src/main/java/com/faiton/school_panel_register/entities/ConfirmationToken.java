package com.faiton.school_panel_register.entities;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class ConfirmationToken {

  

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String token;

  private LocalDate createdDate;

  @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
  @JoinColumn(nullable = false, name = "user_id")
  private User user;

  public ConfirmationToken(User user) {
    this.user = user;
    this.createdDate = LocalDate.now();
    this.token = UUID.randomUUID().toString();
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
 * @return the confirmationToken
 */
public String getToken() {
	return token;
}

/**
 * @param confirmationToken the confirmationToken to set
 */
public void setToken(String token) {
	this.token = token;
}

/**
 * @return the createdDate
 */
public LocalDate getCreatedDate() {
	return createdDate;
}

/**
 * @param createdDate the createdDate to set
 */
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}

/**
 * @return the user
 */
public User getUser() {
	return user;
}

/**
 * @param user the user to set
 */
public void setUser(User user) {
	this.user = user;
}

/**
 * @param id
 * @param confirmationToken
 * @param createdDate
 * @param user
 */
public ConfirmationToken(Long id, String token, LocalDate createdDate, User user) {
	this.id = id;
	this.token = token;
	this.createdDate = createdDate;
	this.user = user;
}

/**
 * @param id
 * @param token
 * @param createdDate
 * @param user
 */
public ConfirmationToken() {
	this.id = 0L;
	this.token = "";
	this.createdDate = null;
	this.user = null;
}


}
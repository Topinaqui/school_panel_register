package com.faiton.school_panel_register.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "educational_institution")
public class EducationalInstitution {
 
  private String name;

  private String description;

  private Boolean active;

  private Boolean enable;
}
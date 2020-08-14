package com.faiton.school_panel_register.entities;

import org.springframework.beans.factory.annotation.Value;

public class SystemInfo {

  @Value("${app.config.system.version:1.0.0}")
  private String version;

  @Value("${app.config.system.version-name:Canary}")
  private String versionName;

  /**
   * @param version
   * @param versionName
   */
  public SystemInfo(String version, String versionName) {
    this.version = version;
    this.versionName = versionName;
  }

  public SystemInfo() {
}

/**
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * @return the versionName
   */
  public String getVersionName() {
    return versionName;
  }

  /**
   * @param versionName the versionName to set
   */
  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

}
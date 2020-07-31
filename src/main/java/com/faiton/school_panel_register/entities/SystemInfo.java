package com.faiton.school_panel_register.entities;

public class SystemInfo {

  private String version;

  private String versionName;

  /**
   * @param version
   * @param versionName
   */
  public SystemInfo(String version, String versionName) {
    this.version = version;
    this.versionName = versionName;
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
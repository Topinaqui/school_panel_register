package com.faiton.school_panel_register.config;

import org.springframework.beans.factory.annotation.Value;

public class AppConfig {

  @Value("${app.config.name:Account}")
  private String appName;

  @Value("${app.config.key}")
  private String appKey;

  @Value("${app.config.jwt.prefix:Bearer}")
  private String jwtPrefix;

  @Value("${app.config.jwt.authentication-header:Authorization}")
  private String authorizationHeader;

  @Value("${app.config.jwt.token-expiration:#{24 * 60 * 60}}")
  private int tokenExpiration;

/**
 * @return the appName
 */
public String getAppName() {
	return appName;
}

/**
 * @param appName the appName to set
 */
public void setAppName(String appName) {
	this.appName = appName;
}

/**
 * @return the appName
 */
public String getAppKey() {
	return appKey;
}

/**
 * @param appKey the appKey to set
 */
public void setAppKey(String appKey) {
	this.appKey = appKey;
}

/**
 * @return the jwtPrefix
 */
public String getJwtPrefix() {
	return jwtPrefix;
}

/**
 * @param jwtPrefix the jwtPrefix to set
 */
public void setJwtPrefix(String jwtPrefix) {
	this.jwtPrefix = jwtPrefix;
}

/**
 * @return the authorizationHeader
 */
public String getAuthorizationHeader() {
	return authorizationHeader;
}

/**
 * @param authorizationHeader the authorizationHeader to set
 */
public void setAuthorizationHeader(String authorizationHeader) {
	this.authorizationHeader = authorizationHeader;
}

/**
 * @return the tokenExpiration
 */
public int getTokenExpiration() {
	return tokenExpiration;
}

/**
 * @param tokenExpiration the tokenExpiration to set
 */
public void setTokenExpiration(int tokenExpiration) {
	this.tokenExpiration = tokenExpiration;
}

}

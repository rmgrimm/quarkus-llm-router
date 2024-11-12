package com.redhat.composer.util;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.security.spi.runtime.AuthorizationController;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.interceptor.Interceptor;


/**
 * Disabled Authorization Controller.
 */
@Alternative
@Priority(Interceptor.Priority.LIBRARY_AFTER)
@ApplicationScoped
public class DisabledAuthController extends AuthorizationController {

  @ConfigProperty(name = "disable.authorization", defaultValue = "false")
  boolean disableAuthorization;

  @Override
  public boolean isAuthorizationEnabled() {
    return !disableAuthorization;
  }
}
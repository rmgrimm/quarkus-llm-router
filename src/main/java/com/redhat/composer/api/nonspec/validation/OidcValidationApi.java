package com.redhat.composer.api.nonspec.validation;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Set;

/**
 * OIDCValidationAPI.
 */
@Path("/auth")
public class OidcValidationApi {

  @Inject
  SecurityIdentity securityIdentity;


  @GET
  @Path("principal")
  public String getPrincipal() {
    return securityIdentity.getPrincipal().getName();
  }


  @GET
  @Path("roles")
  public Set<String> getRoles() {
    return securityIdentity.getRoles();
  }

}

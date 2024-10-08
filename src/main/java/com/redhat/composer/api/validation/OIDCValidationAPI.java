package com.redhat.composer.api.validation;

import java.util.Map;
import java.util.Set;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/auth")
@Authenticated
public class OIDCValidationAPI {

  @Inject
  SecurityIdentity securityIdentity;


  @GET
  @Path("principal")
  public String getPrincipal() {
    return securityIdentity.getPrincipal().getName();
  }


  @GET
  @Path("roles")
  public Set getRoles() {
    return securityIdentity.getRoles();
  }

}

package com.redhat.composer.api.impl;

import com.redhat.composer.api.OidcValidationApi;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

/**
 * OIDCValidationAPI.
 */
@Authenticated
public class OidcValidationApiImpl implements OidcValidationApi {

  @Inject
  SecurityIdentity securityIdentity;

  @Override
  public Uni<String> getPrincipal() {
    return Uni.createFrom().item(
      securityIdentity.getPrincipal().getName()
    );
  }

  @Override
  public Multi<String> getRoles() {
    return Multi.createFrom().iterable(securityIdentity.getRoles());
  }

}

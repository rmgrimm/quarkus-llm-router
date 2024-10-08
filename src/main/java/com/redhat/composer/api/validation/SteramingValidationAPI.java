package com.redhat.composer.api.validation;

import java.util.Random;

import org.jboss.resteasy.reactive.RestStreamElementType;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/streaming")
@Authenticated
public class SteramingValidationAPI {


    @Path("basic")
    public Multi<String> streamBasic() {
        return Multi.createFrom().ticks().every(java.time.Duration.ofSeconds(1))
                .onItem().transform(n -> getRandomLetter());
    }


    @GET
    @Path("basic")
    public String getBasic() {
        return "Hello";
    }

    private String getRandomLetter() {
        Random r = new Random();
        return String.valueOf((char) (r.nextInt(26) + 'a'));
    }

}

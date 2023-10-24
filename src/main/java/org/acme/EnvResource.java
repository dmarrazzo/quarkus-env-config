package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/env")
public class EnvResource {

    @Inject
    Config config;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Config env() {
    
        return config;
    }
}

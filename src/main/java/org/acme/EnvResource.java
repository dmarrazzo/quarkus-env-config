package org.acme;

import io.vertx.ext.web.RoutingContext;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class EnvResource {

    @Inject
    RoutingContext context;

    @Inject
    Config config;

    @Path("/env")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Config env() {
        return config;
    }

    @Path("/ip")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIp() {
        return context.request().host();
    }
}

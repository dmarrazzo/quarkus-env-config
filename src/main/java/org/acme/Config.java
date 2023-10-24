package org.acme;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "example")
public interface Config {

    @JsonProperty("debugFlag")
    @WithDefault("false")
    boolean debugFlag();

    @JsonProperty("host")
    String host();

    @JsonProperty("endpointURL")
    String endpointURL();
}

package io.qaguru.owner.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "file:tmp/secret.properties",
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();

}

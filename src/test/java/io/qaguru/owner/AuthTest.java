package io.qaguru.owner;

import io.qaguru.owner.config.AuthConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


public class AuthTest {

    @Test
    public void testClasspath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class,System.getProperties());

        assertThat(config.username()).isEqualTo("kudryashovd");
        assertThat(config.password()).isEqualTo("12315235");
    }

    @Test
    public void testLocalFile() throws IOException {
        // this is for Jenkins, restricted access
        String content = "username=secret-user\npassword=secret-password";
        Path propsPath = Paths.get("tmp/secret.properties");
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));
        // this is for Jenkins, restricted access

        AuthConfig config = ConfigFactory.create(AuthConfig.class,System.getProperties());

        assertThat(config.username()).isEqualTo("secret-user");
        assertThat(config.password()).isEqualTo("secret-password");

        //this is for Jenkins, restricted access
        Files.delete(propsPath);
        // this is for Jenkins, restricted access
    }


}

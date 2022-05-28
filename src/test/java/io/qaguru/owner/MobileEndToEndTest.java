package io.qaguru.owner;

import io.qaguru.owner.config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MobileEndToEndTest {

    @Test
    public void testAndroid() {
        //console command for passing ./gradlew clean test --tests MobileEndToEndTest -Ddevice=pixel
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("Android");
        assertThat(config.platformVersion()).isEqualTo("32.0");
        assertThat(config.deviceName()).isEqualTo("Google Pixel 4a");
    }

    @Test
    public void testIphone() {
        //console command for passing ./gradlew clean test --tests MobileEndToEndTest -Ddevice=iphone12
        MobileConfig config = ConfigFactory.create(MobileConfig.class, System.getProperties());

        assertThat(config.platformName()).isEqualTo("IOS");
        assertThat(config.platformVersion()).isEqualTo("14.0");
        assertThat(config.deviceName()).isEqualTo("iPhone 12 Pro Max Ultra High");
    }



}

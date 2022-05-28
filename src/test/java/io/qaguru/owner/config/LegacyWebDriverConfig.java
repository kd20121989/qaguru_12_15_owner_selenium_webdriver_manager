package io.qaguru.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LegacyWebDriverConfig {

    public Browser getBrowser(){
        //read data from cli
        String browser = System.getProperty("browser", "CHROME");
        //Other way to set default
//        if (Objects.isNull(browser)) {
//            browser = "CHROME";
//        }

        //conversion to type that we should return
        return Browser.valueOf(browser);
    }

    public String getBaseUrl(){
        return System.getProperty("baseUrl", "https://github.com");
    }

    public URL getRemoteUrl() {
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "https://selenium:4444/wd/hub";
        }
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

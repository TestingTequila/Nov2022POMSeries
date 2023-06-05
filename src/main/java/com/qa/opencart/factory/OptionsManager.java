package com.qa.opencart.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class OptionsManager {

    private Properties properties;
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    public OptionsManager(Properties properties) {
        this.properties = properties;
    }

    public ChromeOptions getChromeOptions() {
        co = new ChromeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless").trim())) co.addArguments("--headless");
        if (Boolean.parseBoolean(properties.getProperty("incognito").trim())) co.addArguments("--incognito");
        return co;
    }

    public FirefoxOptions getFirefoxOptions() {
        fo = new FirefoxOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless").trim())) fo.addArguments("--headless");
        if (Boolean.parseBoolean(properties.getProperty("incognito").trim())) fo.addArguments("--incognito");
        return fo;
    }

    public EdgeOptions getEdgeOptions() {
        eo = new EdgeOptions();
        if (Boolean.parseBoolean(properties.getProperty("headless").trim())) eo.addArguments("--headless");
        if (Boolean.parseBoolean(properties.getProperty("incognito").trim())) eo.addArguments("--incognito");
        return eo;
    }
}

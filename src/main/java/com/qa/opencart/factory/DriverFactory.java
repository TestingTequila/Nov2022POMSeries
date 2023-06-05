package com.qa.opencart.factory;

import com.qa.opencart.utils.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    public WebDriver driver;
    public Properties properties;
    public OptionsManager optionsManager;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(Properties properties) {
        optionsManager = new OptionsManager(properties);
        String browserName = properties.getProperty("browserType").toLowerCase().trim();
        System.out.println("Browser name is : " + browserName);
        if (browserName.equalsIgnoreCase("Chrome")) {
            //driver = new ChromeDriver(optionsManager.getChromeOptions());
            tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            //driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
            tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
        } else if (browserName.equalsIgnoreCase("edge")) {
            //driver = new EdgeDriver(optionsManager.getEdgeOptions());
            tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
        } else if (browserName.equalsIgnoreCase("IE")) {
            //driver = new InternetExplorerDriver();
            tlDriver.set(new InternetExplorerDriver());
        } else {
            System.out.println("Please pass the correct browser name");
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(properties.getProperty("url"));
        return getDriver();

    }

    public synchronized static WebDriver getDriver() {
        return tlDriver.get();
    }

    public void closeBrowser() {
        getDriver().quit();
    }

    public Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream(Constants.PROPERTY_FILE_PATH);
            properties.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    public static String getScreenshot() {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("User.dir") + "/screenshot" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(srcFile, destination);
            //FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}

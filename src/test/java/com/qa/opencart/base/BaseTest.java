package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {

    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;

    protected ProductInfoPage productInfoPage;

    protected SearchResultPage searchResultPage;
    protected RegistrationPage registrationPage;

    protected SoftAssert sf;
    DriverFactory df;
    WebDriver driver;

    protected Properties properties;

    @BeforeTest
    public void setUp() {
        df = new DriverFactory();
        properties = df.initProp();
        driver = df.initDriver(properties);
        loginPage = new LoginPage(driver);
        sf = new SoftAssert();

    }

    @AfterTest
    public void tearDown() {
        df.closeBrowser();
    }
}

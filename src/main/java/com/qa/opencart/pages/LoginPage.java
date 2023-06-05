package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By emailId = By.id("input-email");
    private By password = By.id("input-password");
    private By loginBtn = By.xpath("//input[@type='submit']");
    private By forgotPwdLink = By.linkText("Forgotten Password");

    private By searchField = By.xpath("//input[@name='search']");
    private By registerLink = By.linkText("Register");

    public String getLoginPageTitle() {
        return elementUtil.doWaitForTitleAndFetch(Constants.TIME_OUT, Constants.LOGIN_PAGE_TITLE);
    }

    public String getLoginPageUrl() {
        return elementUtil.doWaitForUrlContainsAndFetch(Constants.TIME_OUT, Constants.LOGIN_PAGE_URL_PARTIAL_VALUE);
    }

    public boolean isForgotPwdLinkAvailable() {
        return elementUtil.doIsDisplayed(forgotPwdLink);
    }

    public MyAccountPage doLogin(String username, String pwd) {
        elementUtil.doSendKeys(emailId, username);
        elementUtil.doSendKeys(password, pwd);
        elementUtil.doClick(loginBtn);
        return new MyAccountPage(driver);
    }

    public RegistrationPage doRegistration() {
        elementUtil.doClick(registerLink);
        return new RegistrationPage(driver);
    }


}

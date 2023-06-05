package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    private ElementUtil elementUtil;
    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");

    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");

    private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
    private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");
    private By agreeCheckbox = By.xpath("//input[@type='checkbox' and @value=1]");
    private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
    private By registerSuccessMessage = By.cssSelector("div#content h1");
    private By logoutLink = By.linkText("Logout");
    private By registrationLink = By.linkText("Register");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public boolean registerUser(String firstName, String lastName, String email, String telephone, String password, String subscribe) {
        elementUtil.doSendKeys(this.firstName, firstName);
        elementUtil.doSendKeys(this.lastName, lastName);
        elementUtil.doSendKeys(this.password, password);
        elementUtil.doSendKeys(this.email, email);
        elementUtil.doSendKeys(this.telephone, telephone);
        elementUtil.doSendKeys(this.password, password);
        elementUtil.doSendKeys(this.confirmPassword, password);
        if (subscribe.equalsIgnoreCase("Yes")) {
            elementUtil.doClick(subscribeYes);
        } else {
            elementUtil.doClick(subscribeNo);
        }

        elementUtil.doClick(agreeCheckbox);
        elementUtil.doClick(continueButton);
        String actualRegistrationPageTitle = elementUtil.doWaitForTitleAndFetch(5000, Constants.USER_REGISTRATION_SUCCESS_MSG);
        elementUtil.doClick(logoutLink);
        elementUtil.doClick(registrationLink);
        if (actualRegistrationPageTitle.contains("Created")) {
            return true;
        } else {
            return false;
        }

    }

}

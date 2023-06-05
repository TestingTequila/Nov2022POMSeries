package com.qa.opencart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtil {

    WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement doGetElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> doGetElements(By locator) {
        return driver.findElements(locator);
    }

    public void doSendKeys(By locator, String text) {
        doGetElement(locator).clear();
        doGetElement(locator).sendKeys(text);
    }

    public void doClick(By locator) {
        doGetElement(locator).click();
    }

    public boolean doIsDisplayed(By locator) {
        return doGetElement(locator).isDisplayed();
    }


    public String doWaitForUrlContainsAndFetch(int timeOut, String urlFractionValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.urlContains(urlFractionValue));
        return driver.getCurrentUrl();
    }

    public String doWaitForTitleAndFetch(int timeOut, String titleValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.titleContains(titleValue));
        return driver.getTitle();
    }

    public int doGetElementCount(By locator) {
        return doGetElements(locator).size();
    }

    public String doGetText(By locator) {
        return doGetElement(locator).getText();
    }

    public void doClear(By locator) {
        doGetElement(locator).clear();
    }
}

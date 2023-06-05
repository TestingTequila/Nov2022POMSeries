package com.qa.opencart.pages;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class MyAccountPage {

    WebDriver driver;
    ElementUtil elementUtil;

    private By logoutLink = By.linkText("Logout");
    private By myAccountIcon = By.xpath("//span[normalize-space()='My Account']");

    private By accountsHeaders = By.xpath("//div[@id='content']/h2");

    private By searchTextBox = By.name("search");

    private By searchBtn = By.xpath("//span[@class='input-group-btn']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public boolean LogoutLinkExists() {
        return elementUtil.doIsDisplayed(logoutLink);
    }

    public String getAccountsPageTitle() {
        String title = elementUtil.doWaitForTitleAndFetch(Constants.TIME_OUT, Constants.ACCOUNT_PAGE_TITLE);
        System.out.println("Accounts Page Title : " + title);
        return title;
    }

    public String getAccountsPageUrl() {
        String url = elementUtil.doWaitForUrlContainsAndFetch(Constants.TIME_OUT, Constants.ACCOUNT_PAGE_URL_PARTIAL_VALUE);
        System.out.println("Account Page url : " + url);
        return url;

    }

    public boolean isLogoutLinkExists() {
        return elementUtil.doIsDisplayed(logoutLink);
    }

    public boolean isSearchBoxExists() {
        return elementUtil.doIsDisplayed(searchTextBox);
    }

    public List<String> AccountHeadersExists() {
        List<WebElement> accHeaderList = elementUtil.doGetElements(accountsHeaders);
        List<String> headerListText = new ArrayList<>();
        for (WebElement ele : accHeaderList) {
            headerListText.add(ele.getText());
        }
        return headerListText;
    }


    public void enterProduct(String searchProductName) {
        if (isSearchBoxExists()) {
            elementUtil.doSendKeys(searchTextBox, searchProductName);
        } else {
            System.out.println("No Search box exists");
        }
    }

    public void clearTextBox() {
        elementUtil.doClear(searchTextBox);
    }

    public SearchResultPage clickSearchIcon() {
        elementUtil.doClick(searchBtn);
        return new SearchResultPage(driver);
    }

    public void logout() {
        elementUtil.doClick(myAccountIcon);
        elementUtil.doClick(logoutLink);
    }
}

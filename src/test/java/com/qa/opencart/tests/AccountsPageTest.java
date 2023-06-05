package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountsPageTest extends BaseTest {


    @BeforeClass
    public void accPageSetUp() {
        myAccountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(priority = 1)
    public void accountPageTitleTest() {
        String actualTitle = myAccountPage.getAccountsPageTitle();
        Assert.assertEquals(actualTitle, Constants.ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void accountPageUrlTest() {
        String actualUrl = myAccountPage.getAccountsPageUrl();
        Assert.assertTrue(actualUrl.contains(Constants.ACCOUNT_PAGE_URL_PARTIAL_VALUE));
    }

    @Test(priority = 3)
    public void isLogoutExists() {
        Assert.assertTrue(myAccountPage.LogoutLinkExists());
    }

    @Test(priority = 4)
    public void AccountsPageHeadersTest() {
        List<String> actualAccHeaderList = myAccountPage.AccountHeadersExists();
        System.out.println(actualAccHeaderList);
        Assert.assertEquals(actualAccHeaderList, Constants.EXPECTED_ACCOUNT_PAGE_HEADER_LIST);
    }

    @Test(priority = 5)
    public void performSearch() {
        myAccountPage.enterProduct(Constants.SEARCH_PRODUCT_NAME);
        searchResultPage = myAccountPage.clickSearchIcon();

    }



}

package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actualPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualPageTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginPageUrlTest() {
        String actualPageUrl = loginPage.getLoginPageUrl();
        Assert.assertTrue(actualPageUrl.contains(Constants.LOGIN_PAGE_URL_PARTIAL_VALUE));
    }

    @Test(priority = 3)
    public void forgotPwdLinkExistsTest() {
        boolean forgotPwdLink = loginPage.isForgotPwdLinkAvailable();
        Assert.assertTrue(forgotPwdLink);
    }

    @Test(priority = 4)
    public void loginTest() {
        myAccountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(myAccountPage.getAccountsPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
    }
}

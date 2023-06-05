package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseTest {

    @Test(priority = 1)
    public void myAccountPageTest() {
        myAccountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertTrue(myAccountPage.isSearchBoxExists());
    }

    @Test(priority = 2, dataProvider = "getProductName")
    public void getProductCountTest(String productName, String selectProduct) {
        myAccountPage.enterProduct(productName);
        searchResultPage = myAccountPage.clickSearchIcon();
        if (searchResultPage.productSearchCount() > 0) {
            productInfoPage = searchResultPage.selectProduct(selectProduct);
            Assert.assertEquals(productInfoPage.getProductName(), selectProduct);
        }

    }

    @DataProvider
    public Object[][] getProductName() {
        String[][] data = {
                {"Samsung", "Samsung SyncMaster 941BW"},
                {"iMac", "iMac"},
                {"Apple", "Apple Cinema 30\""},
                {"Macbook", "MacBook Pro"}};
        return data;
    }

}

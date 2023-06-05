package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoPageTest extends BaseTest {

    @BeforeTest
    public void applicationLogin() {
        myAccountPage = loginPage.doLogin(properties.getProperty("username"), properties.getProperty("password"));
    }

    @Test(dataProvider = "productDetails")
    public void getImagesCountTest(String searchedProduct, String selectedProduct, int actualProductImageCount) {
        myAccountPage.enterProduct(searchedProduct);
        searchResultPage = myAccountPage.clickSearchIcon();
        productInfoPage = searchResultPage.selectProduct(selectedProduct);
        Assert.assertEquals(productInfoPage.getProductImagesCount(), actualProductImageCount);
    }

    @Test
    public void addToCartTest() throws InterruptedException {
        myAccountPage.enterProduct("MacBook");
        searchResultPage = myAccountPage.clickSearchIcon();
        productInfoPage = searchResultPage.selectProduct("MacBook Pro");
        productInfoPage.enterQuantity(Constants.QUANTITY);
        String actCartMsg = productInfoPage.addProductToCart();

        sf.assertTrue(actCartMsg.contains("Success"));
        sf.assertTrue(actCartMsg.contains("MacBook Pro"));
        sf.assertAll();
    }

    @DataProvider
    public Object[][] productDetails() {
        Object[][] data = {
                {"Macbook", "MacBook Pro", 4},
                {"iMac", "iMac", 3},
                {"Apple", "Apple Cinema 30\"", 6},
                {"Samsung", "Samsung Galaxy Tab 10.1", 7}

        };
        return data;
    }

    @Test
    public void productInfoTest() {
        myAccountPage.enterProduct("Macbook");
        searchResultPage = myAccountPage.clickSearchIcon();
        productInfoPage = searchResultPage.selectProduct("MacBook Pro");
        Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();
        sf.assertEquals(actProductInfoMap.get("Brand"), "Apple");
        sf.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
        sf.assertEquals(actProductInfoMap.get("ProductName"), "MacBook Pro");
        sf.assertEquals(actProductInfoMap.get("productPrice"), "$2,000.00");
        sf.assertAll();
    }
}

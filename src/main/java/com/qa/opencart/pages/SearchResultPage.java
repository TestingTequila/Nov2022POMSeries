package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    WebDriver driver;

    ElementUtil elementUtil;
    private By productSearchItems = By.xpath("//div[contains(@class, 'product-layout')]");


    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public ProductInfoPage selectProduct(String productName) {
        By product = By.linkText(productName);
        elementUtil.doClick(product);
        return new ProductInfoPage(driver);
    }

    public int productSearchCount() {
        return elementUtil.doGetElementCount(productSearchItems);
    }

}

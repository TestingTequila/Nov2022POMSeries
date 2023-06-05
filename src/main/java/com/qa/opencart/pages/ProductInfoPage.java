package com.qa.opencart.pages;

import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class ProductInfoPage {

    WebDriver driver;
    ElementUtil elementUtil;
    List<String> productDetails;
    private By productName = By.xpath("//div[@class='col-sm-4']//h1");

    private By productImages = By.xpath("//ul[@class='thumbnails']/li");

    private By productMetaData = By.xpath("(//div[@class='col-sm-4']/ul)[1]/li");
    private By productPriceData = By.xpath("(//div[@class='col-sm-4']/ul)[2]/li");

    private By productHeaderName = By.xpath("//div[@class='col-sm-4']//h1");

    private By quantity = By.id("input-quantity");

    private By addToCartBtn = By.id("button-cart");

    private By cartSuccessMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private Map<String, String> productInfoMap;

    public ProductInfoPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getProductName() {
        return elementUtil.doGetText(productName);
    }

    public int getProductImagesCount() {
        return elementUtil.doGetElementCount(productImages);
    }


    //Meta Data
    public Map<String, String> getProductInfo() {
        //productInfoMap = new HashMap<String, String>(); //Order not maintained
        //productInfoMap = new LinkedHashMap<String, String>(); // Order is maintained
        productInfoMap = new TreeMap<String, String>(); // Sorting
        productInfoMap.put("ProductName", elementUtil.doGetText(productHeaderName));
        getProductMetaData();
        getProductPriceData();
        System.out.println(productInfoMap);
        return productInfoMap;

    }

    private void getProductMetaData() {
        List<WebElement> metaList = elementUtil.doGetElements(productMetaData);
        for (WebElement e : metaList) {
            String meta = e.getText();
            String[] metaInfo = meta.split(":");
            String key = metaInfo[0].trim();
            String value = metaInfo[1].trim();
            productInfoMap.put(key, value);
        }
    }

    private void getProductPriceData() {
        List<WebElement> priceList = elementUtil.doGetElements(productPriceData);
        String price = priceList.get(0).getText();
        String exTax = priceList.get(1).getText();
        String[] exTaxVal = exTax.split(":");
        String k = exTaxVal[0];
        String v = exTaxVal[1];
        productInfoMap.put("productPrice", price);
        productInfoMap.put(k, v);
    }

    public void enterQuantity(int count) {
        elementUtil.doSendKeys(quantity, String.valueOf(count));
    }

    public String addProductToCart() throws InterruptedException {
        elementUtil.doClick(addToCartBtn);
        Thread.sleep(1000);
        String msg = elementUtil.doGetText(cartSuccessMessage);
        return msg;
    }


}

package com.qa.opencart.factory;

import org.openqa.selenium.By;

public class OrderPage {

    By orderId = By.id("oder");
    By priceId = By.id("oder");
    By productId = By.id("oder");
    public  void getOrder()
    {
        System.out.println(this.orderId);
    }

    public  void getPrice()
    {
        System.out.println(this.priceId);
    }

    public  void getProduct()
    {
        System.out.println(this.productId);
    }
}

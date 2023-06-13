package com.qa.opencart.factory;

import org.openqa.selenium.By;

public class OrderPage {

    By orderId = By.id("oder");
    public  void getOrder()
    {
        System.out.println(this.orderId);
    }
}

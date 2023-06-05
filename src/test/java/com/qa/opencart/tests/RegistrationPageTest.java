package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationPageTest extends BaseTest {

    @BeforeClass
    public void regPageSetUp() {
        registrationPage = loginPage.doRegistration();
    }


    public String getRandomEmail() {
        Random random = new Random();
        int num = random.nextInt(1000);
        String email = "ashish.mishra" + num + "@gmail.com";
        return email;
    }

    @Test(dataProvider = "getRegisterDataFromExcel")
    public void registerNewUser(String firstName, String lastName, String telephone, String password, String subscribe) {
        Assert.assertTrue(registrationPage.registerUser(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
    }

    @DataProvider
    public Object[][] getRegisterDataFromExcel() {
        return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
    }

}

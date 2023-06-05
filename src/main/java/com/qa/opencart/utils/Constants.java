package com.qa.opencart.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final int TIME_OUT = 5;

    public static final String LOGIN_PAGE_TITLE = "Account Login";

    public static final String ACCOUNT_PAGE_TITLE = "My Account";

    public static final String LOGIN_PAGE_URL_PARTIAL_VALUE = "account/login";

    public static final String ACCOUNT_PAGE_URL_PARTIAL_VALUE = "account/account";

    public static final String SEARCH_PRODUCT_NAME = "Macbook";

    public static final String PROPERTY_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";

    public static final List<String> EXPECTED_ACCOUNT_PAGE_HEADER_LIST = Arrays.asList("My Account", "My Orders",
            "My Affiliate Account", "Newsletter");
    public static final String PRODUCT_NAME = "MacBook Air";
    public static final int QUANTITY = 2;
    public static final String TEST_DATA_SHEET_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\testdata\\OpenCartTestData.xlsx";

    public static final String USER_REGISTRATION_SUCCESS_MSG = "Your Account Has Been Created!";
    public static final String REGISTER_SHEET_NAME = "register";
}

package com.solvd.pages.ios;

import com.solvd.pages.common.CartBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartBasePage.class)
public class CartPage extends CartBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }
}
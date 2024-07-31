package com.solvd.pages.android;

import com.solvd.pages.common.ProductBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductBasePage.class)
public class ProductPage extends ProductBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
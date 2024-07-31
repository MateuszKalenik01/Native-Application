package com.solvd.pages.android;

import com.solvd.pages.common.CatalogBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogBasePage.class)
public class CatalogPage extends CatalogBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    public CatalogPage(WebDriver driver) {
        super(driver);
    }
}
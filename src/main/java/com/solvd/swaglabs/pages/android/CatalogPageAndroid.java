package com.solvd.swaglabs.pages.android;

import com.solvd.swaglabs.pages.common.CatalogBasePage;
import com.solvd.swaglabs.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogBasePage.class)
public class CatalogPageAndroid extends CatalogBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageAndroid.class);

    public CatalogPageAndroid(WebDriver driver) {
        super(driver);
    }
}

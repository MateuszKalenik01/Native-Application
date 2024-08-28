package com.solvd.swaglabs.pages.ios;

import com.solvd.swaglabs.pages.common.CatalogBasePage;
import com.solvd.swaglabs.pages.common.LoginBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogBasePage.class)

public class CatalogPageIOS extends CatalogBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageIOS.class);

    public CatalogPageIOS(WebDriver driver) {
        super(driver);
    }
}

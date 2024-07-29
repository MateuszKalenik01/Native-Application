package com.solvd.pages.ios;

import com.solvd.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    public CatalogPage(WebDriver driver) {
        super(driver);
    }
}
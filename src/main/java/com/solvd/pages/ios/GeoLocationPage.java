package com.solvd.pages.ios;

import com.solvd.pages.common.CartBasePage;
import com.solvd.pages.common.GeoLocationBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationBasePage.class)
public class GeoLocationPage extends GeoLocationBasePage {
    public GeoLocationPage(WebDriver driver) {
        super(driver);
    }
}

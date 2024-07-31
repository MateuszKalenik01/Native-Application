package com.solvd.pages.android;

import com.solvd.pages.common.GeoLocationBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationBasePage.class)
public class GeoLocationPage extends GeoLocationBasePage {
    public GeoLocationPage(WebDriver driver) {
        super(driver);
    }
}

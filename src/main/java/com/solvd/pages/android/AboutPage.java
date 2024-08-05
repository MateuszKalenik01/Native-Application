package com.solvd.pages.android;

import com.solvd.pages.common.AboutBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutBasePage.class)
public class AboutPage extends AboutBasePage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }
}


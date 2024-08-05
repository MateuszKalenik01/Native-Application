package com.solvd.pages.android;

import com.solvd.pages.common.BasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BasePage.class)
public class Page extends BasePage {
    public Page(WebDriver driver) {
        super(driver);
    }
}

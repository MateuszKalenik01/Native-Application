package com.solvd.pages.android;

import com.solvd.pages.common.DrawingBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingBasePage.class)
public class DrawingPage extends DrawingBasePage {
    public DrawingPage(WebDriver driver) {
        super(driver);
    }
}
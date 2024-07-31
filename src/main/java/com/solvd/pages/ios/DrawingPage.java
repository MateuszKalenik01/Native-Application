package com.solvd.pages.ios;

import com.solvd.pages.common.DrawingBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingBasePage.class)
public class DrawingPage extends DrawingBasePage {
    public DrawingPage(WebDriver driver) {
        super(driver);
    }
}
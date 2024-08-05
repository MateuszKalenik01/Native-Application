package com.solvd.pages.ios;

import com.solvd.pages.common.AboutBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutBasePage.class)
public class AboutPage extends AboutBasePage {


    public AboutPage(WebDriver driver) {
        super(driver);

    }
}
package com.solvd.pages.ios;

import com.solvd.pages.common.DrawingBasePage;
import com.solvd.pages.common.WebBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebBasePage.class)
public class WebPage extends WebBasePage {

    public WebPage(WebDriver driver) {
        super(driver);

    }
}

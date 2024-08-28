package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.utils.ios.IOSUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebBasePage extends AbstractPage implements IOSUtils {
    public WebBasePage(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getBannerElement();
}

package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AboutBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutBasePage.class);

    protected abstract ExtendedWebElement pageTitle();
    protected abstract ExtendedWebElement link();

    public AboutBasePage(WebDriver driver) {
        super(driver);
    }

    public WebBasePage clickLink() {
        link().click();
        return initPage(getDriver(), WebBasePage.class);
    }
}

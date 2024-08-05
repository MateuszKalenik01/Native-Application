package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AboutBasePage extends BasePage{
    private static final Logger LOGGER = LoggerFactory.getLogger(AboutBasePage.class);

    @ExtendedFindBy(iosPredicate = "About ")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Go to saucelabs.com\"`]")
    private ExtendedWebElement link;

    public AboutBasePage(WebDriver driver) {
        super(driver);
    }

    public WebBasePage clickLink(){
        link.click();
        return initPage(getDriver(), WebBasePage.class);
    }
}

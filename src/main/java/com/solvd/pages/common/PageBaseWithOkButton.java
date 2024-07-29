package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class PageBaseWithOkButton extends PageBase {

    @ExtendedFindBy(accessibilityId = "OK")
    protected ExtendedWebElement okButton;

    public PageBaseWithOkButton(WebDriver driver) {
        super(driver);
    }
}
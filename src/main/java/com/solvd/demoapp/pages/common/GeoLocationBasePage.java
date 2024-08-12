package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

public abstract class GeoLocationBasePage extends BasePage {

    public GeoLocationBasePage(WebDriver driver) {
        super(driver);
    }
    public abstract ExtendedWebElement getLongitudeElement();
    public abstract ExtendedWebElement getLatitudeElement();

}
package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class MoreMenuBasePage extends BaseOkPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoreMenuBasePage.class);

    public MoreMenuBasePage(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getDrawingButton();
    protected abstract ExtendedWebElement getGeoLocationButton();
    protected abstract ExtendedWebElement getAboutButton();
    protected abstract ExtendedWebElement getResetButton();
    protected abstract ExtendedWebElement getResetButtonPopup();
    public abstract CatalogBasePage clickCatalogButton();
    public DrawingBasePage clickDrawingButton() {
        getDrawingButton().click();
        return initPage(getDriver(), DrawingBasePage.class);
    }

    public GeoLocationBasePage clickGeoLocationButton() {
        getGeoLocationButton().click();
        return initPage(getDriver(), GeoLocationBasePage.class);
    }

    public abstract boolean resetApplication();

    public AboutBasePage clickAboutButton() {
        getAboutButton().click();
        return initPage(getDriver(), AboutBasePage.class);
    }
}
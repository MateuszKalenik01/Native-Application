package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public abstract class MoreMenuBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoreMenuBasePage.class);

    @ExtendedFindBy(accessibilityId = "Drawing-menu-item")
    private ExtendedWebElement drawingButton;

    @ExtendedFindBy(accessibilityId = "GeoLocation-menu-item")
    private ExtendedWebElement geoLocationButton;

    @ExtendedFindBy(accessibilityId = "About-menu-item")
    private ExtendedWebElement aboutButton;

    @ExtendedFindBy(accessibilityId = "ResetAppState-menu-item")
    private ExtendedWebElement resetButton;

    @ExtendedFindBy(accessibilityId = "RESET APP")
    private ExtendedWebElement resetButtonPopup;

    public MoreMenuBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingButton);
    }
    public DrawingBasePage clickDrawingButton() {
        drawingButton.click();

        return initPage(getDriver(), DrawingBasePage.class);
    }

    public GeoLocationBasePage clickGeoLocationButton() {
        geoLocationButton.click();
        return initPage(getDriver(), GeoLocationBasePage.class);
    }
    public MoreMenuBasePage resetApplication(){
        resetButton.click();
        resetButtonPopup.click();
        acceptButton.click();
        return initPage(getDriver(), MoreMenuBasePage.class);
    }
    public AboutBasePage clickAboutButton() {
        aboutButton.click();
        return initPage(getDriver(), AboutBasePage.class);
    }
}
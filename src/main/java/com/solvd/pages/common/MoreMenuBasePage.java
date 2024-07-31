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

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Drawing-menu-item\"`]")
    private ExtendedWebElement drawingButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"GeoLocation-menu-item\"`]")
    private ExtendedWebElement geoLocationButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"ResetAppState-menu-item\"`]")
    private ExtendedWebElement resetButton;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"RESET APP\"`]")
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

}
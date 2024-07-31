package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testng.Assert.assertEquals;

public class GeoLocationBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationBasePage.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[7]")
    private ExtendedWebElement longitude;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[8]")
    private ExtendedWebElement latitude;

    public GeoLocationBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(longitude);
    }

    public String getLongitude() {
        return longitude.getText();
    }

    public String getLatitude() {
        return latitude.getText();
    }
    public void validateGeoLocation(String expectedLatitude, String expectedLongitude) {
        String actualLatitude = getLatitude();
        String actualLongitude = getLongitude();
        assertEquals(actualLatitude, expectedLatitude, "Latitude does not match the expected value");
        assertEquals(actualLongitude, expectedLongitude, "Longitude does not match the expected value");
    }
}
package com.solvd.demoapp.service;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeoLocationService implements ICustomTypePageFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationService.class);

    public String getLongitude(ExtendedWebElement longitudeElement) {
        return longitudeElement.getText();
    }

    public String getLatitude(ExtendedWebElement latitudeElement) {
        return latitudeElement.getText();
    }

    public void validateGeoLocation(ExtendedWebElement latitudeElement, ExtendedWebElement longitudeElement, String expectedLatitude, String expectedLongitude) {
        String actualLatitude = getLatitude(latitudeElement);
        String actualLongitude = getLongitude(longitudeElement);
        if (!actualLatitude.equals(expectedLatitude)) {
            LOGGER.error("Latitude does not match the expected value. Expected: {}, Actual: {}", expectedLatitude, actualLatitude);
        }
        if (!actualLongitude.equals(expectedLongitude)) {
            LOGGER.error("Longitude does not match the expected value. Expected: {}, Actual: {}", expectedLongitude, actualLongitude);
        }
        assert actualLatitude.equals(expectedLatitude) : "Latitude does not match the expected value";
        assert actualLongitude.equals(expectedLongitude) : "Longitude does not match the expected value";
    }
}
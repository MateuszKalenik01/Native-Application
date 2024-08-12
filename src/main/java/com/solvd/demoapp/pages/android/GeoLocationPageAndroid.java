package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.pages.common.GeoLocationBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationBasePage.class)
public class GeoLocationPageAndroid extends GeoLocationBasePage {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/latitudeTV")
    private ExtendedWebElement latitude;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/longitudeTV")
    private ExtendedWebElement longitude;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;
    @FindBy (id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private ExtendedWebElement allowLocation;
    public GeoLocationPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(longitude);
        handlePermissionIfNeeded();
    }
    private void handlePermissionIfNeeded() {
        if (allowLocation.isElementPresent(2)) {
            allowLocation.click();
        }
    }
    @Override
    public ExtendedWebElement getLongitudeElement() {
        return longitude;
    }

    @Override
    public ExtendedWebElement getLatitudeElement() {
        return latitude;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
}

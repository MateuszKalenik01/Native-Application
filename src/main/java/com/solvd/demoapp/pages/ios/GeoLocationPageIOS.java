package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.pages.common.GeoLocationBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationBasePage.class)
public class GeoLocationPageIOS extends GeoLocationBasePage {
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[7]")
    private ExtendedWebElement longitude;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"GeoLocation-screen\"`]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    private IOSMenu menu;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[8]")
    private ExtendedWebElement latitude;

    public GeoLocationPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(longitude);
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

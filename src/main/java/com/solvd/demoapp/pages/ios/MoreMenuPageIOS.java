package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MoreMenuBasePage.class)
public class MoreMenuPageIOS extends MoreMenuBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoreMenuPageIOS.class);

    @ExtendedFindBy(accessibilityId = "Drawing-menu-item")
    private ExtendedWebElement drawingButtonIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther")
    private IOSMenu menu;

    @ExtendedFindBy(accessibilityId = "OK")
    private ExtendedWebElement acceptButtonIOS;

    @ExtendedFindBy(accessibilityId = "GeoLocation-menu-item")
    private ExtendedWebElement geoLocationButtonIOS;

    @ExtendedFindBy(accessibilityId = "About-menu-item")
    private ExtendedWebElement aboutButtonIOS;

    @ExtendedFindBy(accessibilityId = "ResetAppState-menu-item")
    private ExtendedWebElement resetButtonIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"RESET APP\"`]")
    private ExtendedWebElement resetButtonPopupIOS;

    public MoreMenuPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingButtonIOS);
    }
    @Override
    protected ExtendedWebElement getDrawingButton() {
        return drawingButtonIOS;
    }

    @Override
    protected ExtendedWebElement getGeoLocationButton() {
        return geoLocationButtonIOS;
    }

    @Override
    protected ExtendedWebElement getAboutButton() {
        return aboutButtonIOS;
    }

    @Override
    protected ExtendedWebElement getResetButton() {
        return resetButtonIOS;
    }

    @Override
    protected ExtendedWebElement getResetButtonPopup() {
        return resetButtonPopupIOS;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonIOS;
    }
    @Override
    public boolean resetApplication() {
        getResetButton().click();
        getResetButtonPopup().click();
        return getOkButton().clickIfPresent();

    }
    @Override
    public CatalogBasePage clickCatalogButton() {
      //MORE MENU DOESNT HAVE CATOLOG INSIDE ON IOS
        return null;
    }
}
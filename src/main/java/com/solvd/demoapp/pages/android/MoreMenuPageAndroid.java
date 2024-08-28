package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.MoreMenuBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreMenuBasePage.class)
public class MoreMenuPageAndroid extends MoreMenuBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoreMenuPageAndroid.class);

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Drawing']")
    private ExtendedWebElement drawingButtonAndroid;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement acceptButtonAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Geo Location']")
    private ExtendedWebElement geoLocationButtonAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='About']")
    private ExtendedWebElement aboutButtonAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Reset App State']")
    private ExtendedWebElement resetButtonAndroid;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private ExtendedWebElement resetButtonPopupAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Catalog']")
    private ExtendedWebElement catalogButtonAndroid;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    public MoreMenuPageAndroid(WebDriver driver) {
        super(driver);;
        setUiLoadedMarker(drawingButtonAndroid);
    }
    @Override
    protected ExtendedWebElement getDrawingButton() {
        return drawingButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getGeoLocationButton() {
        return geoLocationButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getAboutButton() {
        return aboutButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getResetButton() {
        return resetButtonAndroid;
    }

    @Override
    protected ExtendedWebElement getResetButtonPopup() {
        return resetButtonPopupAndroid;
    }
    @Override
    public CatalogBasePage clickCatalogButton() {
        catalogButtonAndroid.click();
        return initPage(getDriver(), CatalogBasePage.class);
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonAndroid;
    }
    @Override
    public boolean resetApplication() {
        getResetButton().click();
        getResetButtonPopup().click();
        return getOkButton().clickIfPresent();
    }
}
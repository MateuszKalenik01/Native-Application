package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.pages.common.DrawingBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingBasePage.class)
public class DrawingPageAndroid extends DrawingBasePage {

    @ExtendedFindBy(accessibilityId = "Pad to draw on")
    private ExtendedWebElement drawingBackground;

    @ExtendedFindBy(accessibilityId = "Save anything drawn on pad")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(accessibilityId = "Removes anything drawn on pad")
    private ExtendedWebElement clearButton;
    @FindBy(id="com.android.permissioncontroller:id/permission_allow_button")
    private ExtendedWebElement allowPermission;
    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    public DrawingPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingBackground);
    }

    @Override
    public ExtendedWebElement getDrawingBackground() {
        handlePermissionIfNeeded();
        return drawingBackground;
    }

    @Override
    protected ExtendedWebElement getSaveButton() {
        return saveButton;
    }

    @Override
    protected ExtendedWebElement getClearButton() {
        return clearButton;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }

    private void handlePermissionIfNeeded() {
        if (allowPermission.isElementPresent(2)) {
            allowPermission.click();
        }
    }
}
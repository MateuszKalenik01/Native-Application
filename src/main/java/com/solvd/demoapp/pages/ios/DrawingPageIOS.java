package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.pages.common.DrawingBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingBasePage.class)
public class DrawingPageIOS extends DrawingBasePage {

    @ExtendedFindBy(accessibilityId = "DrawingBackground Icons")
    private ExtendedWebElement drawingBackground;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeOther")
    private IOSMenu menu;

    @ExtendedFindBy(accessibilityId = "SaveButton Icons")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(accessibilityId = "ClearButton Icons")
    private ExtendedWebElement clearButton;

    public DrawingPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(drawingBackground);
    }

    @Override
    public ExtendedWebElement getDrawingBackground() {
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
}
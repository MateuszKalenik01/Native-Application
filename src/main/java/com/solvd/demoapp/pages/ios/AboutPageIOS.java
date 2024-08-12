package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.pages.common.AboutBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutBasePage.class)
public class AboutPageIOS extends AboutBasePage {
    @ExtendedFindBy(iosPredicate = "label == 'About'")
    private ExtendedWebElement pageTitleIOS;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"About-screen\"`]/XCUIElementTypeOther[3]/XCUIElementTypeOther")
    private IOSMenu menu;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Go to saucelabs.com\"`]")
    private ExtendedWebElement linkIOS;

    public AboutPageIOS(WebDriver driver) {
        super(driver);

    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement pageTitle() {
        return pageTitleIOS;
    }

    @Override
    protected ExtendedWebElement link() {
        return linkIOS;
    }
}
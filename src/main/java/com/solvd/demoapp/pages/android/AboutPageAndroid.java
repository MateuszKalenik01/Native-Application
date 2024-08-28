package com.solvd.demoapp.pages.android;

import com.solvd.demoapp.components.menu.AndroidMenu;
import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.pages.common.AboutBasePage;
import com.solvd.demoapp.utils.Constants;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutBasePage.class)
public class AboutPageAndroid extends AboutBasePage {

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/aboutTV")
    private ExtendedWebElement pageTitleAndroid;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/webTV")
    private ExtendedWebElement linkAndroid;

    @FindBy(id = Constants.Menu_Android)
    private AndroidMenu menu;

    public AboutPageAndroid(WebDriver driver) {
        super(driver);
    }
    @Override
    protected ExtendedWebElement pageTitle() {
        return pageTitleAndroid;
    }

    @Override
    protected ExtendedWebElement link() {
        return linkAndroid;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
}


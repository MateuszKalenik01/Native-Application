package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseOkPage extends AbstractPage implements IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    protected abstract ExtendedWebElement getOkButton();
    public abstract BaseMenu getBaseMenu();
    public BaseOkPage(WebDriver driver) {
        super(driver);
    }
}

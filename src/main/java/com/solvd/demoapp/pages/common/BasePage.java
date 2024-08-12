package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage extends AbstractPage implements IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

    public abstract BaseMenu getBaseMenu();
    public BasePage(WebDriver driver) {
        super(driver);
    }

}

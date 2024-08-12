package com.solvd.swaglabs.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatalogBasePage extends AbstractPage {
        private static final Logger LOGGER = LoggerFactory.getLogger(CatalogBasePage.class);

        public CatalogBasePage(WebDriver driver) {
            super(driver);
        }
    }
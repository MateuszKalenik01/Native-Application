package com.solvd.demoapp.pages.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class DrawingBasePage extends BasePage {


    public DrawingBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getDrawingBackground();
    protected abstract ExtendedWebElement getSaveButton();
    protected abstract ExtendedWebElement getClearButton();


}
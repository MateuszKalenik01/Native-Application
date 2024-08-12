package com.solvd.demoapp.components.rating;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public abstract class RatingBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingBase.class);

    protected abstract List<ExtendedWebElement> selectedStars();
    protected abstract List<ExtendedWebElement> unselectedStars();

    public RatingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public  abstract void selectRandomRating();

    public abstract void clickRandomUnselectedRating();

    public abstract void clickRandomRating(List<ExtendedWebElement> stars, String rating);
}
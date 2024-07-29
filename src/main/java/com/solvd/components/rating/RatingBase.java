package com.solvd.components.rating;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public abstract class RatingBase extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingBase.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarSelected Icons\"`]")
    private List<ExtendedWebElement> selectedStars;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarUnSelected Icons\"`]")
    private List<ExtendedWebElement> unselectedStars;

    public RatingBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectRandomStar() {
        LOGGER.info("selectRandomStar()");
        clickRandomStar(selectedStars, "selected");
    }

    public void clickRandomUnselectedStar() {
        LOGGER.info("clickRandomUnselectedStar()");
        clickRandomStar(unselectedStars, "unselected");
    }

    private void clickRandomStar(List<ExtendedWebElement> stars, String starType) {
        if (stars != null && !stars.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(stars.size());
            LOGGER.info("Clicking " + index + " " + starType + " star");
            stars.get(index).click();
        } else {
            LOGGER.info("No " + starType + " stars to be clicked");
        }
    }
}
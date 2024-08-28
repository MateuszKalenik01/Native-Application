package com.solvd.demoapp.components.rating.ios;

import com.solvd.demoapp.components.rating.RatingBase;
import com.solvd.demoapp.components.rating.android.RatingAndroid;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = RatingBase.class)
public class RatingIOS extends RatingBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingAndroid.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarSelected Icons\"`]")
    private List<ExtendedWebElement> selectedStars;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"StarUnSelected Icons\"`]")
    private List<ExtendedWebElement> unselectedStars;
    public RatingIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @Override
    protected List<ExtendedWebElement> selectedStars() {
        return selectedStars;
    }

    @Override
    protected List<ExtendedWebElement> unselectedStars() {
        return unselectedStars;
    }

    @Override
    public void clickRandomRating(List<ExtendedWebElement> stars, String rating) {
        if (stars != null && !stars.isEmpty()) {
            Random rand = new Random();
            int index = rand.nextInt(stars.size());
            LOGGER.info("Clicking " + index + " " + rating);
            stars.get(index).click();
        } else {
            LOGGER.info("No " + rating + " stars to be clicked");
        }
    }
    @Override
    public void selectRandomRating() {
        clickRandomRating(selectedStars(), "selected");
    }
    @Override
    public void clickRandomUnselectedRating() {
        clickRandomRating(unselectedStars(), "unselected");
    }

}
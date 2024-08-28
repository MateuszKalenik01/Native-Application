package com.solvd.demoapp.components.rating.android;

import com.solvd.demoapp.components.rating.RatingBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RatingBase.class)
public class RatingAndroid extends RatingBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(RatingAndroid.class);
    public RatingAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @FindBy(xpath = "//android.widget.ImageView[contains(@resource-id, 'com.saucelabs.mydemoapp.android:id/start')]\n")
    private List<ExtendedWebElement> stars;


    @Override
    protected List<ExtendedWebElement> selectedStars() {
        return stars;
    }

    @Override
    protected List<ExtendedWebElement> unselectedStars() {
        return null;
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

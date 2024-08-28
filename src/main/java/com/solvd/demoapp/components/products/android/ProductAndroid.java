package com.solvd.demoapp.components.products.android;

import com.solvd.demoapp.components.products.ProductBase;

import com.solvd.demoapp.components.rating.RatingBase;
import com.solvd.demoapp.components.rating.android.RatingAndroid;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = RatingBase.class)

public class ProductAndroid extends ProductBase {

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.saucelabs.mydemoapp.android:id/rattingV\"]/android.widget.LinearLayout")
    private RatingAndroid ratingAndroid;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/titleTV']")
    private ExtendedWebElement productNameElement;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/priceTV']")
    private ExtendedWebElement productPriceElement;

    public ProductAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @Override
    public void submitProductRating() {
        rating().selectRandomRating();
    }
    protected RatingAndroid rating() {
        return ratingAndroid;
    }

    @Override
    protected ExtendedWebElement productNameElement() {
        return productNameElement;
    }
    public List<ExtendedWebElement> getProductAttributes() {
        List<ExtendedWebElement> productAttributes = new ArrayList<>();
        productAttributes.add(productNameElement);
        productAttributes.add(productPriceElement);
        return productAttributes;
    }
    @Override
    protected ExtendedWebElement productPriceElement() {
        return productPriceElement;
    }
}
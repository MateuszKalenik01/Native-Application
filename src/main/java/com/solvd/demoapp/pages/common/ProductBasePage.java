package com.solvd.demoapp.pages.common;

import com.solvd.demoapp.components.quantity.QuantityBase;
import com.solvd.demoapp.components.rating.RatingBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Getter
public abstract class ProductBasePage extends BaseOkPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBasePage.class);

    public abstract ExtendedWebElement addToCartButton();
    protected abstract ExtendedWebElement price();
    protected abstract RatingBase rating();
    protected abstract ExtendedWebElement colorContainer();
    protected abstract List<ExtendedWebElement> colorOptions();
    protected abstract ExtendedWebElement productNameElement();
    public abstract boolean updateQuantityIncrement();
    public abstract boolean updateQuantityDecrement();
    public abstract QuantityBase getQuantity();
    public abstract void clickBackButton();

    protected String selectedColor;

    public ProductBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(addToCartButton());
    }

    public CartBasePage addToCartAndOpenCart() {
        clickAddToCartButton();
        return getBaseMenu().clickCartButton();
    }

    public void clickAddToCartButton() {
        addToCartButton().click();
    }

    public ExtendedWebElement rateProduct() {
        rating().selectRandomRating();
        return getOkButton();
    }

    public ExtendedWebElement getRandomColor() {
        Random random = new Random();
        int numberOfColors = colorOptions().size();
        LOGGER.info("Number of colors available: " + numberOfColors);

        if (numberOfColors > 0) {
            ExtendedWebElement selectedColorElement = colorOptions().get(random.nextInt(numberOfColors));
            LOGGER.info("Selected color: " + selectedColorElement.getText());
            return selectedColorElement;
        } else {
            throw new NoSuchElementException("No color options available.");
        }
    }

    public void addToCartWithRandomColor() {
        LOGGER.info("Adding product to cart with a random color");
        ExtendedWebElement randomColor = getRandomColor();
        selectedColor = extractColorText(randomColor.getAttribute("name"));
        randomColor.click();
        addToCartButton().click();
    }

    private String extractColorText(String text) {
        Matcher matcher = Pattern.compile("[A-Z][a-z]*").matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return text;
    }

    public String getProductName() {
        String productName = productNameElement().getText();
        LOGGER.info("Product name: " + productName);
        return productName;
    }
}
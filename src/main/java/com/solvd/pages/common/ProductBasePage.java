package com.solvd.pages.common;

import com.solvd.components.rating.Rating;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
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
public abstract class ProductBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBasePage.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;
    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement addQuantity;
    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement reduceQuantity;
    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private Rating rating;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    private ExtendedWebElement colorContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private List<ExtendedWebElement> colorOptions;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'ProductDetails-screen'`]/**/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement productNameElement;
    @Getter
    private String selectedColor;
    public ProductBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(addToCartButton);

    }

    public CartBasePage addToCartAndOpenCart() {
        clickAddToCartButton();
        return navigateToCart();
    }

    public ProductBasePage addToCartAndGoBack() {
        clickAddToCartButton();
        return clickGoBackButton();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public ProductBasePage clickGoBackButton() {
        goBackButton.click();
        return initPage(getDriver(), ProductBasePage.class);
    }

    public ExtendedWebElement rateProduct() {
        rating.selectRandomRating();
        return acceptButton;
    }
    public ExtendedWebElement getRandomColor() {
        Random random = new Random();
        int numberOfColors = colorOptions.size();
        LOGGER.info("Number of colors available: " + numberOfColors);

        if (numberOfColors > 0) {
            ExtendedWebElement selectedColorElement = colorOptions.get(random.nextInt(numberOfColors));
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
        addToCartButton.click();
    }
    private String extractColorText(String text) {
        Matcher matcher = Pattern.compile("[A-Z][a-z]*").matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return text;
    }
    public String getProductName() {
        String productName = productNameElement.getText();
        LOGGER.info("Product name: " + productName);
        return productName;
    }
}
package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
public abstract class CartBasePage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartBasePage.class);

    @ExtendedFindBy(accessibilityId = "GoShopping")
    private ExtendedWebElement goShoppingButton;

    @ExtendedFindBy(accessibilityId = "No Items")
    private ExtendedWebElement noItemsMessage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Cart-screen\"`]")
    private ExtendedWebElement cartScreen;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"Remove Item\"`]")
    private List<ExtendedWebElement> removeItemButtons;

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement plusButton;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement minusButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[5]")
    private ExtendedWebElement value;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[12]")
    private ExtendedWebElement addedProductColor;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/**/XCUIElementTypeStaticText")
    private List<ExtendedWebElement> productNames;
    public CartBasePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goShoppingButton);
    }

    public boolean deleteRandomItemFromCart () {
        Random rand = new Random();
        int size = removeItemButtons.size();
        int index = rand.nextInt(size);
        removeItemButtons.get(index).click();
        if (!removeItemButtons.isEmpty()) {
            int newSize = removeItemButtons.size();
            return newSize > size;
        } else {
            return noItemsMessage.isDisplayed();
        }
    }
    public boolean isProductAddedToCartWithCorrectColor(String expectedColor) {
        String actualColor = addedProductColor.getText();
        LOGGER.info("Expected color: " + expectedColor + ", Actual color: " + actualColor);
        return actualColor.equalsIgnoreCase(expectedColor);
    }
    public List<String> getProductNames() {
        return productNames.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }
    public List<String> getCartProductNames() {
        return productNames.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public boolean areProductsInCart(List<String> expectedProducts) {
        List<String> cartProducts = getCartProductNames();
        return expectedProducts.stream().allMatch(cartProducts::contains);
    }
}
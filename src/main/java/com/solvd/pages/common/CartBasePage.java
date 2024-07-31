package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

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

    public CartBasePage(WebDriver driver) {
        super(driver);
    }

    public boolean deleteRandomItemFromCart () {
        Random rand = new Random();
        int size = removeItemButtons.size();
        int index = rand.nextInt(size);
        LOGGER.info("removeItemFromCart(" + index + ")");
        removeItemButtons.get(index).click();
        if (!removeItemButtons.isEmpty()) {
            int newSize = removeItemButtons.size();
            return newSize > size;
        } else {
            return noItemsMessage.isDisplayed();
        }
    }

}
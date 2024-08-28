package com.solvd.demoapp.components.quantity;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class QuantityIOS extends QuantityBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityIOS.class);

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement plusButton;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement minusButton;

    @ExtendedFindBy(accessibilityId = "Amount")
    private ExtendedWebElement quantityElement;

    public QuantityIOS(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("QuantityIOS()");
    }

    @Override
    public boolean incrementQuantity(int amount) {
        LOGGER.info("incrementQuantity(" + amount + ")");
        int initialQuantity = getCurrentQuantity();
        int updatedQuantity = updateQuantity(amount, plusButton);
        return updatedQuantity - initialQuantity == amount;
    }

    @Override
    public boolean decrementQuantity(int amount) {
        LOGGER.info("decrementQuantity(" + amount + ")");
        int initialQuantity = getCurrentQuantity();
        if (amount > initialQuantity) {
            throw new IllegalArgumentException("Amount to decrement exceeds current quantity");
        }
        int updatedQuantity = updateQuantity(amount, minusButton);
        return initialQuantity - updatedQuantity == amount;
    }

    private int getCurrentQuantity() {
        return Integer.parseInt(quantityElement.getAttribute("value"));
    }

    private int updateQuantity(int amount, ExtendedWebElement button) {
        LOGGER.info("updateQuantity()");
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        for (int i = 0; i < amount; i++) {
            button.click();
        }
        return getCurrentQuantity();
    }

    @Override
    public ExtendedWebElement getQuantityElement() {
        return quantityElement;
    }
}

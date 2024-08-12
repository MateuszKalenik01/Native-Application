package com.solvd.demoapp.components.quantity;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class QuantityAndroid extends QuantityBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityAndroid.class);

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private ExtendedWebElement plusButton;

    @FindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private ExtendedWebElement minusButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private ExtendedWebElement quantityElement;

    public QuantityAndroid(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        LOGGER.info("QuantityAndroid()");
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
        return Integer.parseInt(quantityElement.getText());
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

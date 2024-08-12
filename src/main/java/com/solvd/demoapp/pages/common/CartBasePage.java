package com.solvd.demoapp.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Getter
public abstract class CartBasePage extends BasePage {
    protected abstract ExtendedWebElement getGoShoppingButton();
    public abstract ExtendedWebElement getNoItemsMessage();
    protected abstract ExtendedWebElement getCartScreen();
    public abstract List<ExtendedWebElement> getRemoveItemButtons();
    protected abstract ExtendedWebElement getPlusButton();
    protected abstract ExtendedWebElement getMinusButton();
    protected abstract ExtendedWebElement getPrice();
    public abstract ExtendedWebElement getAddedProductColor();
    public abstract List<ExtendedWebElement> getProductNames();
    public abstract String getValue();

    public CartBasePage(WebDriver driver) {
        super(driver);
    }
    public boolean deleteItemFromCart(List<ExtendedWebElement> removeItemButtons, ExtendedWebElement noItemsMessage) {
        Random rand = new Random();
        int size = removeItemButtons.size();
        int index = rand.nextInt(size);
        removeItemButtons.get(index).click();
        if (!removeItemButtons.isEmpty()) {
            int newSize = removeItemButtons.size();
            return newSize > size;
        } else {
            return noItemsMessage.isElementPresent();
        }
    }
    public List<String> getProductNames(List<ExtendedWebElement> productNames) {
        return productNames.stream().map(ExtendedWebElement::getText).collect(Collectors.toList());
    }

    public boolean areProductsInCart(List<ExtendedWebElement> productNames, List<String> expectedProducts) {
        List<String> cartProducts = getProductNames(productNames);
        return expectedProducts.stream().allMatch(cartProducts::contains);
    }
    public abstract boolean isProductAddedWithCorrectColor(ExtendedWebElement extendedWebElement,String string);
}
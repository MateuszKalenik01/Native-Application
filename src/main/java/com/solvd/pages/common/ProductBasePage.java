package com.solvd.pages.common;

import com.solvd.components.rating.Rating;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    public ProductBasePage(WebDriver driver) {
        super(driver);

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
        rating.selectRandomStar();
        return acceptButton;
    }

}
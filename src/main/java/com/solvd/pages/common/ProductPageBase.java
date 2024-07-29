package com.solvd.pages.common;

import com.solvd.components.rating.Rating;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Getter
public abstract class ProductPageBase extends PageBaseWithOkButton {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageBase.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private Rating rating;

    public ProductPageBase(WebDriver driver) {
        super(driver);
        LOGGER.info("ProductPageBase()");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(this.addToCartButton);
    }

    public CartPageBase addToCartAndOpenCart() {
        LOGGER.info("addToCartAndOpenCart()");
        clickAddToCartButton();
        return navigateToCart();
    }

    public ProductPageBase addToCartAndGoBack() {
        LOGGER.info("addToCartAndGoBack()");
        clickAddToCartButton();
        return clickGoBackButton();
    }

    public void clickAddToCartButton() {
        LOGGER.info("clickAddToCartButton()");
        addToCartButton.click();
    }

    public ProductPageBase clickGoBackButton() {
        LOGGER.info("clickGoBackButton()");
        goBackButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    public ExtendedWebElement rateProduct() {
        LOGGER.info("rateProduct()");
        rating.selectRandomStar();
        return okButton;
    }

}
package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.components.quantity.QuantityIOS;
import com.solvd.demoapp.components.rating.ios.RatingIOS;
import com.solvd.demoapp.pages.common.ProductBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

@Getter
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductBasePage.class)
public class ProductPageIOS extends ProductBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductPageIOS.class);

    @ExtendedFindBy(iosPredicate = "name == \"AddToCart\"")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "OK")
    private ExtendedWebElement acceptButtonIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[4]/XCUIElementTypeOther")
    private IOSMenu menu;

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement addQuantity;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement reduceQuantity;

    @ExtendedFindBy(accessibilityId = "Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "BackButton Icons")
    private ExtendedWebElement goBackButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]")
    private RatingIOS ratingIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]")
    private ExtendedWebElement colorContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeButton")
    private List<ExtendedWebElement> colorOptions;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]" +
            "/XCUIElementTypeOther[2]/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[4]")
    private QuantityIOS quantity;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'ProductDetails-screen'`]/**/XCUIElementTypeStaticText[2]")
    private ExtendedWebElement productNameElement;
    @ExtendedFindBy(iosClassChain ="**/XCUIElementTypeOther[`name == \"ProductDetails-screen\"`]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    private ExtendedWebElement backButton;
    public ProductPageIOS(WebDriver driver) {
        super(driver);
    }
    @Override
    public ExtendedWebElement addToCartButton() {
        return addToCartButton;
    }

    @Override
    protected ExtendedWebElement price() {
        return price;
    }

    @Override
    protected RatingIOS rating() {
        return ratingIOS;
    }

    @Override
    protected ExtendedWebElement colorContainer() {
        return colorContainer;
    }

    @Override
    protected List<ExtendedWebElement> colorOptions() {
        return colorOptions;
    }

    @Override
    protected ExtendedWebElement productNameElement() {
        return productNameElement;
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    public void clickBackButton() {
        backButton.click();
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonIOS;
    }

    @Override
    public boolean updateQuantityIncrement() {
        LOGGER.info("Increment random quantity");
        int incrementValue = new Random().nextInt(4) + 1;
        return getQuantity().incrementQuantity(incrementValue);
    }
    @Override
    public boolean updateQuantityDecrement() {
        LOGGER.info("Decrement random quantity");
        int currentQuantity = Integer.parseInt(getQuantity().getQuantityElement().getText());

        if (currentQuantity > 0) {
            int decrementValue = new Random().nextInt(currentQuantity) + 1;
            return getQuantity().decrementQuantity(decrementValue);
        } else {
            LOGGER.info("Cannot decrement quantity below zero.");
            return false;
        }
    }
}
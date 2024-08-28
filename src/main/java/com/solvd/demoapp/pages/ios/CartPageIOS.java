package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.pages.common.CartBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartBasePage.class)
public class CartPageIOS extends CartBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartPageIOS.class);

    @ExtendedFindBy(accessibilityId = "GoShopping")
    private ExtendedWebElement goShoppingButtonIOS;

    @ExtendedFindBy(accessibilityId = "No Items")
    private ExtendedWebElement noItemsMessageIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Cart-screen\"`]")
    private ExtendedWebElement cartScreenIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == \"Remove Item\"`]")
    private List<ExtendedWebElement> removeItemButtonsIOS;

    @ExtendedFindBy(accessibilityId = "AddPlus Icons")
    private ExtendedWebElement plusButtonIOS;

    @ExtendedFindBy(accessibilityId = "SubtractMinus Icons")
    private ExtendedWebElement minusButtonIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[5]")
    private ExtendedWebElement valueIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[12]")
    private ExtendedWebElement addedProductColorIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/**/XCUIElementTypeStaticText")
    private List<ExtendedWebElement> productNamesIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Cart-screen\"`]/XCUIElementTypeOther[7]/XCUIElementTypeOther")
    private IOSMenu menu;

    public CartPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(goShoppingButtonIOS);
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement getGoShoppingButton() {
        return goShoppingButtonIOS;
    }

    @Override
    public ExtendedWebElement getNoItemsMessage() {
        return noItemsMessageIOS;
    }

    @Override
    protected ExtendedWebElement getCartScreen() {
        return cartScreenIOS;
    }

    @Override
    public List<ExtendedWebElement> getRemoveItemButtons() {
        return removeItemButtonsIOS;
    }

    @Override
    protected ExtendedWebElement getPlusButton() {
        return plusButtonIOS;
    }

    @Override
    protected ExtendedWebElement getMinusButton() {
        return minusButtonIOS;
    }

    @Override
    protected ExtendedWebElement getPrice() {
        return valueIOS;
    }

    @Override
    public ExtendedWebElement getAddedProductColor() {
        return addedProductColorIOS;
    }

    @Override
    public List<ExtendedWebElement> getProductNames() {
        return productNamesIOS;
    }
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeCell/XCUIElementTypeStaticText[5]")
    private ExtendedWebElement value;

    public boolean isProductAddedWithCorrectColor(ExtendedWebElement addedProductColor, String expectedColor) {
        String actualColor = addedProductColor.getText();
        LOGGER.info("Expected color: " + expectedColor + ", Actual color: " + actualColor);
        return actualColor.equalsIgnoreCase(expectedColor);
    }

    @Override
    public String getValue() {
        return value.getText();
    }
}
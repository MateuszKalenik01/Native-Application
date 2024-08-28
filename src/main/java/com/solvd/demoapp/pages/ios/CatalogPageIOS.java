package com.solvd.demoapp.pages.ios;

import com.solvd.demoapp.components.menu.BaseMenu;
import com.solvd.demoapp.components.menu.IOSMenu;
import com.solvd.demoapp.components.products.ProductBase;
import com.solvd.demoapp.components.products.ios.ProductIos;
import com.solvd.demoapp.pages.common.CatalogBasePage;
import com.solvd.demoapp.pages.common.ProductBasePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogBasePage.class)
public class CatalogPageIOS extends CatalogBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPageIOS.class);

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]")
    private ExtendedWebElement catalogScreenIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Catalog-screen\"`]/XCUIElementTypeOther[5]/XCUIElementTypeOther")
    private IOSMenu menu;

    @ExtendedFindBy(accessibilityId = "OK")
    private ExtendedWebElement acceptButtonIOS;

    @ExtendedFindBy(iosPredicate = "name == \"ProductItem\"")
    private List<ProductIos> productsIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Button\"`]")
    private ExtendedWebElement sortButtonIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Ascending\"`]")
    private ExtendedWebElement sortByNameAscendingIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Name - Descending\"`]")
    private ExtendedWebElement sortByNameDescendingIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Ascending\"`]")
    private ExtendedWebElement sortByPriceAscendingIOS;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeButton[`name == \"Price - Descending\"`]")
    private ExtendedWebElement sortByPriceDescendingIOS;

    public CatalogPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(catalogScreenIOS);
    }
    @Override
    public BaseMenu getBaseMenu() {
        return menu;
    }
    @Override
    protected ExtendedWebElement getCatalogScreen() {
        return catalogScreenIOS;
    }

    @Override
    protected List<ProductIos> getProducts() {
        return productsIOS;
    }

    @Override
    protected ExtendedWebElement getSortButton() {
        return sortButtonIOS;
    }

    @Override
    protected ExtendedWebElement getSortByNameAscending() {
        return sortByNameAscendingIOS;
    }

    @Override
    protected ExtendedWebElement getSortByNameDescending() {
        return sortByNameDescendingIOS;
    }

    @Override
    protected ExtendedWebElement getSortByPriceAscending() {
        return sortByPriceAscendingIOS;
    }

    @Override
    protected ExtendedWebElement getSortByPriceDescending() {
        return sortByPriceDescendingIOS;
    }
    @Override
    protected ExtendedWebElement getOkButton(){
        return acceptButtonIOS;
    }
    @Override
    public List<String> addTwoRandomProductsWithRandomColorsToCart() {
        List<String> addedProducts = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            ProductBasePage productPage = openRandomProductPage();
            productPage.addToCartButton().click();
            addedProducts.add(productPage.getProductName());
            productPage.clickBackButton();
        }

        return addedProducts;
    }
    @Override
    public boolean isSortedByNameAscending() {
        List<String> productNames = getProductNames();
        List<String> sortedNames = productNames.stream().sorted().toList();
        return productNames.equals(sortedNames);
    }
    @Override
    public boolean isSortedByNameDescending() {
        List<String> productNames = getProductNames();
        List<String> sortedNames = productNames.stream().sorted(Comparator.reverseOrder()).toList();
        return productNames.equals(sortedNames);
    }
    @Override
    public List<String> getProductNames() {
        return getProducts().stream().map(ProductBase::getProductName).collect(Collectors.toList());
    }
}
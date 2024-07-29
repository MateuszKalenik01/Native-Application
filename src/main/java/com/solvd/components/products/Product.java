package com.solvd.components.products;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Product extends ProductBase {
    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
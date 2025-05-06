package com.lahirucw.ebayautomation.pages;

import com.lahirucw.ebayautomation.utilities.DriverManager;
import com.lahirucw.ebayautomation.utilities.LoggerUtil;
import com.lahirucw.ebayautomation.utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author lahirucw
 */
public class ProductDetailsPage {

    @FindBy(css = ".x-item-title__mainTitle")
    private WebElement productNameElement;

    @FindBy(css = ".x-price-primary")
    private WebElement productPriceElement;

    @FindBy(id = "atcBtn_btn")
    private WebElement addToCartButton;

    @FindBy(css = ".ux-call-to-action--secondary")
    private WebElement goToCartButton;

    public ProductDetailsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.cssSelector(".x-item-title__mainTitle"));
        LoggerUtil.info("ProductDetailsPage initialized");
    }

    public String getProductName() {
        String name = productNameElement.getText();
        LoggerUtil.info("Retrieved product name: " + name);
        return name;
    }

    public String getProductPrice() {
        String price = productPriceElement.getText();
        LoggerUtil.info("Retrieved product price: " + price);
        return price;
    }

    public ProductDetailsPage addToCart() {
        WaitUtil.waitForClickable(addToCartButton);
        addToCartButton.click();
        LoggerUtil.info("Clicked Add to Cart");
        return this;
    }

    public CartPage goToCart() {
        WaitUtil.waitForClickable(goToCartButton);
        goToCartButton.click();
        LoggerUtil.info("Navigated to Cart");
        return new CartPage();
    }

}

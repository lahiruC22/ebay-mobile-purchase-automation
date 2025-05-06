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
public class CartPage {

    @FindBy(css = ".item-title")
    private WebElement cartProductNameElement;

    @FindBy(css = ".item-price")
    private WebElement cartProductPriceElement;

    @FindBy(css = ".total-price")
    private WebElement estimatedTotalElement;

    @FindBy(id = "checkoutBtn")
    private WebElement checkoutButton;

    public CartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.cssSelector(".item-title"));
        LoggerUtil.info("CartPage initialized");
    }

    public String getCartProductName() {
        String name = cartProductNameElement.getText();
        LoggerUtil.info("Retrieved cart product name: " + name);
        return name;
    }

    public String getCartProductPrice() {
        String price = cartProductPriceElement.getText();
        LoggerUtil.info("Retrieved cart product price: " + price);
        return price;
    }

    public String getEstimatedTotal() {
        String total = estimatedTotalElement.getText();
        LoggerUtil.info("Retrieved estimated total: " + total);
        return total;
    }

    public CheckoutPage proceedToCheckout() {
        WaitUtil.waitForClickable(checkoutButton);
        checkoutButton.click();
        LoggerUtil.info("Proceeded to checkout");
        return new CheckoutPage();
    }

}

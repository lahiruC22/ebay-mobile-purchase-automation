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
public class CheckoutPage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "addressLine1")
    private WebElement addressField;

    @FindBy(css = ".item-title")
    private WebElement cartProductNameElement;

    @FindBy(css = ".item-price")
    private WebElement cartProductPriceElement;

    @FindBy(css = ".summary-item-list__total")
    private WebElement estimatedTotalElement;

    @FindBy(id = "checkoutBtn")
    private WebElement checkoutButton;

    public CheckoutPage() {
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

    public void enterEmail(String email) {
        WaitUtil.waitForClickable(emailField);
        emailField.sendKeys(email);
        LoggerUtil.info("Entered email: " + email);
    }

    public void enterShippingInfo(String firstName, String lastName, String address) {
        WaitUtil.waitForClickable(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        LoggerUtil.info("Entered shipping info: " + firstName + " " + lastName + ", " + address);
    }

}

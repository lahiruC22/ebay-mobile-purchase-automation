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

    @FindBy(id = "continueBtn")
    private WebElement continueButton;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(id = "lastName")
    private WebElement lastNameField;

    @FindBy(id = "address")
    private WebElement addressField;

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.id("email"));
        LoggerUtil.info("CheckoutPage initialized");
    }

    public void enterEmail(String email) {
        WaitUtil.waitForClickable(emailField);
        emailField.sendKeys(email);
        LoggerUtil.info("Entered email: " + email);
    }

    public void clickContinue() {
        WaitUtil.waitForClickable(continueButton);
        continueButton.click();
        LoggerUtil.info("Clicked Continue");
    }

    public void enterShippingInfo(String firstName, String lastName, String address) {
        WaitUtil.waitForClickable(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        addressField.sendKeys(address);
        LoggerUtil.info("Entered shipping info: " + firstName + " " + lastName + ", " + address);
    }

}

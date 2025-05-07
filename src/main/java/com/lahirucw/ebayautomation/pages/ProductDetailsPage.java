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

    @FindBy(css = ".x-price-primary")
    private WebElement productPriceElement;

    @FindBy(id = "binBtn_btn_1")
    private WebElement buyItNowButton;

    public ProductDetailsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.cssSelector(".x-item-title__mainTitle"));
        LoggerUtil.info("ProductDetailsPage initialized");
    }

    public String getProductPrice() {
        String price = productPriceElement.getText();
        LoggerUtil.info("Retrieved product price.");
        return price;
    }

    public UserSelectorModal butItNow() {
        WaitUtil.waitForClickable(buyItNowButton);
        buyItNowButton.click();
        LoggerUtil.info("Clicked But It Now");
        return new UserSelectorModal();
    }
}

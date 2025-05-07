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
public class UserSelectorModal {

    @FindBy(css = ".ux-bin-nudge__title .ux-textspans")
    private WebElement productNameElement;

    @FindBy(css = ".ux-bin-nudge__guestCheckOut a.fake-btn--secondary")
    private WebElement checkOutAsGuestButton;

    public UserSelectorModal() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.cssSelector(".ux-bin-nudge__title"));
        LoggerUtil.info("User Selector model initialized");
    }

    public String getProductName() {
        WaitUtil.waitForAllVisible(By.cssSelector(".ux-bin-nudge__title .ux-textspans"));
        String name = productNameElement.getText();
        LoggerUtil.info("Retrieved product name.");
        return name;
    }

    public CheckoutPage checkOutAsGuest() {
        WaitUtil.waitForClickable(checkOutAsGuestButton);
        checkOutAsGuestButton.click();
        LoggerUtil.info("Clicked Check out as Guest!");
        return new CheckoutPage();
    }

}

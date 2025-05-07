package com.lahirucw.ebayautomation.pages;

import com.lahirucw.ebayautomation.utilities.DriverManager;
import com.lahirucw.ebayautomation.utilities.LoggerUtil;
import com.lahirucw.ebayautomation.utilities.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Handles navigation to the "Cell Phones & Smartphones category
 *
 * @author lahirucw
 */
public class HomePage {

    @FindBy(xpath = "//li[contains(@class, 'vl-flyout-nav__js-tab')]//a[contains(text(), 'Electronics')]")
    private WebElement electronicsMenu;

    @FindBy(xpath = "//a[contains(text(), 'Smartphones and accessories')]")
    private WebElement cellPhonesLink;

    @FindBy(xpath = "//a[contains(@href, 'Cell-Phones') and .//span[text()='See All']]")
    private WebElement seeAllLink;

    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForVisible(By.id("gh-ac"));
        LoggerUtil.info("HomePage initialized");
    }

    public SearchResultsPage selectCellPhones() {
        Actions actions = new Actions(DriverManager.getDriver());
        WaitUtil.waitForClickable(electronicsMenu);
        actions.moveToElement(electronicsMenu).perform();
        WaitUtil.waitForClickable(cellPhonesLink);
        cellPhonesLink.click();
        LoggerUtil.info("Navigated to Cell Phones & Smartphones");
        WaitUtil.waitForClickable(seeAllLink);
        seeAllLink.click();
        LoggerUtil.info("Cicked See All link");
        return new SearchResultsPage();
    }

}

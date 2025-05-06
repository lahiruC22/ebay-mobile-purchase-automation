package com.lahirucw.ebayautomation.pages;

import com.lahirucw.ebayautomation.utilities.DriverManager;
import com.lahirucw.ebayautomation.utilities.LoggerUtil;
import com.lahirucw.ebayautomation.utilities.WaitUtil;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author lahirucw
 */
public class SearchResultsPage {

    public SearchResultsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        WaitUtil.waitForAllVisible(By.cssSelector(".srp-results .s-item"));
        LoggerUtil.info("SearchResultsPage initialized");
    }

    public SearchResultsPage selectScreenSize(String size) {
        WebElement screenSizeSection = WaitUtil.waitForClickable(By.xpath("//span[text()='Screen Size']"));
        screenSizeSection.click();
        WebElement sizeCheckbox = WaitUtil.waitForClickable(By.xpath("//input[@aria-label='" + size + "']"));
        sizeCheckbox.click();
        WaitUtil.waitForAllVisible(By.cssSelector(".srp-results .s-item"));
        LoggerUtil.info("Applied screen size filter: " + size);
        return this;
    }

    public ProductDetailsPage selectFirstProduct() {
        List<WebElement> products = DriverManager.getDriver().findElements(By.cssSelector(".srp-results .s-item .s-item__link"));
        WaitUtil.waitForClickable(products.get(0));
        products.get(0).click();
        LoggerUtil.info("Selected first product");
        return new ProductDetailsPage();
    }

}

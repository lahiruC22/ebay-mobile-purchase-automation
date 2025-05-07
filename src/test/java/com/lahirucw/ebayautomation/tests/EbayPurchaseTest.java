package com.lahirucw.ebayautomation.tests;

import com.lahirucw.ebayautomation.pages.CheckoutPage;
import com.lahirucw.ebayautomation.pages.CheckoutPage;
import com.lahirucw.ebayautomation.pages.HomePage;
import com.lahirucw.ebayautomation.pages.ProductDetailsPage;
import com.lahirucw.ebayautomation.pages.SearchResultsPage;
import com.lahirucw.ebayautomation.pages.UserSelectorModal;
import com.lahirucw.ebayautomation.utilities.DriverManager;
import com.lahirucw.ebayautomation.utilities.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author lahirucw
 */
public class EbayPurchaseTest extends BaseClass {

    @Test(dataProvider = "purchaseData", dataProviderClass = com.lahirucw.ebayautomation.testdata.TestDataProvider.class)
    public void testEbayPurchase(String screenSize, String email, String firstName, String lastName, String address) {
        LoggerUtil.info("Starting test: testEbayPurchase");

        // Verify URL
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.ebay.com/", "URL verification failed");
        LoggerUtil.info("URL verified: " + currentUrl);

        // Select cell phones
        SearchResultsPage searchPage = new HomePage().selectCellPhones();
        LoggerUtil.info("Navigated to Cell Phones & Smartphones");

        // Select first product
        ProductDetailsPage productPage = searchPage.selectFirstProduct();
        LoggerUtil.info("Selected first product");
        
        // Get and print the product price.
        String productPrice = productPage.getProductPrice();
        LoggerUtil.info("Extracted Product Price: " + productPrice);
        
        // Click Buy it now
        UserSelectorModal userSelectorModal = productPage.butItNow();
        LoggerUtil.info("Clicked buy it now and initialized user selection modal.");

        // Get and print product name
        String productName = userSelectorModal.getProductName();
        LoggerUtil.info("Extracted Product Name: " + productName);
        
        // Click Checkout as guest and get Cart Page
        CheckoutPage checkoutPage =  userSelectorModal.checkOutAsGuest();
        LoggerUtil.info("Navigated to cart page.");
        
        // Assert product details in cart
        Assert.assertEquals(
                checkoutPage.getCartProductName(), 
                productName, 
                "Product name in cart does not match");
        
        Assert.assertEquals(
                checkoutPage.getCartProductPrice()
                        .replace("US", "").replaceAll("[^\\d.$]", "").trim()
                , productPrice,
                "Product price in cart does not match");
        
        LoggerUtil.info("Cart details verified");

        // Get and print estimated total
        String estimatedTotal = checkoutPage
                .getEstimatedTotal()
                .replace("US", "").replaceAll("[^\\d.$]", "").trim();
        LoggerUtil.info("Estimated Total: " + estimatedTotal);

        // Enter email
        checkoutPage.enterEmail(email);
        LoggerUtil.info("Entered email: " + email);

        // Enter shipping info
        checkoutPage.enterShippingInfo(firstName, lastName, address);
        LoggerUtil.info("Entered shipping info");
    }

}

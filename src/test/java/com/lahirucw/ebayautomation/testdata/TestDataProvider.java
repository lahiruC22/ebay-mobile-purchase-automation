package com.lahirucw.ebayautomation.testdata;

import org.testng.annotations.DataProvider;

/**
 *
 * @author lahirucw
 */
public class TestDataProvider {

    @DataProvider(name = "purchaseData")
    public Object[][] getPurchaseData() {
        return new Object[][]{
            {"6.0 - 6.9 in", "test@example.com", "John", "Doe", "123 Main St"}
        };
    }

}

package com.lahirucw.ebayautomation.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 *
 * @author lahirucw
 */
public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private static final int MAX_RETRY = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && count < MAX_RETRY) {
            count++;
            return true;
        }
        return false;
    }
}

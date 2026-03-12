package org.test_task.listeners;

import io.qameta.allure.Allure;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int currentAttempt = 0;
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (currentAttempt < MAX_RETRY_COUNT) {
            currentAttempt++;
            Allure.step("Retry test '" + result.getName() + "', attempt " + currentAttempt);
            return true;
        }
        return false;
    }
}
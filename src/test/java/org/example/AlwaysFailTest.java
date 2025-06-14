package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlwaysFailTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyFailureOnInvalidCondition() {
        logger.warn("AlwaysFailTest – this will always fail");
        Assert.fail("Intentional permanent failure");
    }
}


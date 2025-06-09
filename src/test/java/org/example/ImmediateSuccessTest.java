package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ImmediateSuccessTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void success() {
        Reporter.log("ImmediateSuccessTest – always passes", true);
        Assert.assertTrue(true);
    }
}

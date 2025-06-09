package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AlwaysFailTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void alwaysFail() {
        Reporter.log("AlwaysFailTest – this will always fail", true);
        Assert.fail("Intentional permanent failure");
    }
}


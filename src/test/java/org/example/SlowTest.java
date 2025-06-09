package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SlowTest {

    private static final long TIMEOUT_MILLIS       = 2_000L;
    private static final long SLEEP_DURATION_MILLIS = 500L;

    @Test(retryAnalyzer = RetryAnalyzer.class, timeOut = TIMEOUT_MILLIS)
    public void slow() throws InterruptedException {
        Reporter.log("SlowTest – sleeping 500ms", true);
        Thread.sleep(SLEEP_DURATION_MILLIS);
        Assert.assertTrue(true);
    }
}

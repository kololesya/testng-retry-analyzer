package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SlowTest extends BaseTest {

    private static final long TIMEOUT_MILLIS = 2_000L;
    private static final long SLEEP_DURATION_MILLIS = 500L;

    @Test(retryAnalyzer = RetryAnalyzer.class, timeOut = TIMEOUT_MILLIS)
    public void verifyExecutionWithinTimeout() throws InterruptedException {
        logger.info("SlowTest – sleeping {} ms", SLEEP_DURATION_MILLIS);
        Thread.sleep(SLEEP_DURATION_MILLIS);
        Assert.assertTrue(true);
    }
}

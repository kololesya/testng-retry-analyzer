package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class FlakyThreeAttemptsTest {

    private static final AtomicInteger counter = new AtomicInteger(0);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flakyThree() {
        int attempt = counter.incrementAndGet();
        Reporter.log("FlakyThreeAttemptsTest attempt " + attempt, true);
        Assert.assertTrue(attempt >= 3,
                "Failing until 3rd attempt (current: " + attempt + ")");
    }
}

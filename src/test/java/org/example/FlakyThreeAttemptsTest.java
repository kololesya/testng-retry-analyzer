package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class FlakyThreeAttemptsTest extends BaseTest {

    private static final AtomicInteger counter = new AtomicInteger(0); // thread-safe retry counter

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flakyThree() {
        int attempt = counter.incrementAndGet();
        logger.info("FlakyThreeAttemptsTest attempt {}", attempt);
        Assert.assertTrue(attempt >= 3,
                String.format("Failing until 3rd attempt (current: %d)", attempt));
    }
}

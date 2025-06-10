package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.concurrent.atomic.AtomicInteger;

public class FlakyTest extends BaseTest {

    private static final AtomicInteger counter = new AtomicInteger(0); // thread-safe retry counter

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flaky() {
        int attempt = counter.incrementAndGet();
        logger.info("FlakyTest attempt {}", attempt);
        Assert.assertTrue(attempt >= 2, "Intentional failure to demo retry");
    }
}

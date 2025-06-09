package org.example;

import org.example.retry.RetryAnalyzer;
import org.example.retry.RetryListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.concurrent.atomic.AtomicInteger;

public class FlakyTest {
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void flaky() {
        int attempt = counter.incrementAndGet();
        Reporter.log("FlakyTest attempt " + attempt, true);
        Assert.assertTrue(attempt >= 2, "Intentional failure to demo retry");
    }
}

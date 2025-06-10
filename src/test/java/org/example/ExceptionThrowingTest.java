package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.annotations.Test;

public class ExceptionThrowingTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void exceptionTest() {
        logger.warn("ExceptionThrowingTest – about to throw");
        throw new RuntimeException("Intentional exception");
    }
}

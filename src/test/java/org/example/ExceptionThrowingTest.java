package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExceptionThrowingTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void exceptionTest() {
        Reporter.log("ExceptionThrowingTest – about to throw", true);
        throw new RuntimeException("Intentional exception");
    }
}

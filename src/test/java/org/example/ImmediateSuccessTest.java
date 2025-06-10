package org.example;

import org.example.retry.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImmediateSuccessTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void success() {
        logger.info("ImmediateSuccessTest – always passes");
        Assert.assertTrue(true);
    }
}

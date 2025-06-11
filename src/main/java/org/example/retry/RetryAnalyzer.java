package org.example.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger logger = LogManager.getLogger(RetryAnalyzer.class);

    private static final String PROPERTY_KEY = "retry.count";
    private static final String PROPERTIES_FILE = "retry.properties";
    private static final int DEFAULT_RETRY_COUNT = 0;

    private static final int MAX_RETRIES;
    private final AtomicInteger count = new AtomicInteger(0);

    static {
        int retries = DEFAULT_RETRY_COUNT;
        try {
            String prop = System.getProperty(PROPERTY_KEY);
            if (prop != null) {
                retries = Integer.parseInt(prop);
            } else {
                Properties p = new Properties();
                p.load(RetryAnalyzer.class
                        .getClassLoader()
                        .getResourceAsStream(PROPERTIES_FILE));
                retries = Integer.parseInt(
                        p.getProperty(PROPERTY_KEY,
                                String.valueOf(DEFAULT_RETRY_COUNT))
                );
            }
        } catch (IOException | NumberFormatException e) {
            logger.warn("Could not load \"{}\"; defaulting to {}", PROPERTY_KEY, DEFAULT_RETRY_COUNT);
        }
        MAX_RETRIES = retries;
        logger.info(">> RetryAnalyzer initialized with max retries = {}", MAX_RETRIES);
    }

    @Override
    public boolean retry(ITestResult result) {
        int current = count.getAndIncrement();
        if (current < MAX_RETRIES) {
            logger.info("Retrying {}: attempt {}/{}", result.getName(), current + 1, MAX_RETRIES);
            return true;
        }
        return false;
    }
}
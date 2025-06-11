package org.example.retry;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {

    private static final Logger logger = LogManager.getLogger(RetryListener.class);

    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
        if (annotation.getRetryAnalyzerClass() == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
            String name = (testMethod != null) ? testMethod.getName() : "<no-method>";
            logger.info("Attached RetryAnalyzer to {}", name);
        }
    }
}

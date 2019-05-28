package com.jds.testCase.caseRule.listener;

import com.jds.testCase.caseRule.rule.RFailRetry;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 监听器:设置@Test注解的retryAnalyzer属性
 */
public class LCaseRetry implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
                          Method testMethod) {
        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(RFailRetry.class);
        }
    }
}

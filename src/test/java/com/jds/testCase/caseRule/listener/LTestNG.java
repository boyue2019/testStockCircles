package com.jds.testCase.caseRule.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LTestNG implements ITestListener {
    @Override
    public void onTestStart(ITestResult result){};

    @Override
    public void onTestSuccess(ITestResult result){};

    /**
     * 测试用例执行失败后截图、添加日志
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result){
        String failTestName = result.getMethod().getMethodName();
        System.out.println("----执行失败:" + failTestName);
    };

    @Override
    public void onTestSkipped(ITestResult result){};

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){};

    @Override
    public void onStart(ITestContext result){};

    @Override
    public void onFinish(ITestContext result){};
}

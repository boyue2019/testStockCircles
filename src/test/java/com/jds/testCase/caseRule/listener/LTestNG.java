package com.jds.testCase.caseRule.listener;

import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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

    @Step("【报告】失败截图")
    @Attachment(value = "用例执行失败,截图:",type = "image/jpg")
    public byte[] onFailureScreenshot(){
        return PageAction.screenshot();
    }
}

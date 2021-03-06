package com.jds.testCase.caseRule.listener;

import com.jds.testBase.log.Log4jUtils;
import com.jds.testBase.util.PageAction;
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
        Log4jUtils.logError("用例执行失败:" + failTestName); //错误日志
        //onFailureScreenshot(); //截图上传至Allure
    };

    @Override
    public void onTestSkipped(ITestResult result){};

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){};

    @Override
    public void onStart(ITestContext result){};

    @Override
    public void onFinish(ITestContext result){};

    /**
     * 截图上传附件至Allure测试报告
     * @return
     */
    @Step("【报告】失败截图")
    @Attachment(value = "用例执行失败,截图:",type = "image/jpg")
    public byte[] onFailureScreenshot(){
        return PageAction.screenshot();
    }
}

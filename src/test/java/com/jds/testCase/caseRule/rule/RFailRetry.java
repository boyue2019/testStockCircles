package com.jds.testCase.caseRule.rule;

import com.jds.testBase.util.CommonTools;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RFailRetry implements IRetryAnalyzer{
    private int retryCount = 0; //计数器
    private static int maxRetryCount; //设置重跑次数

    /**
     * 用例执行失败重跑:重写IRetryAnalyzer的retry方法
     * @param result
     * @return 返回true代表重跑,false则继续.
     */
    @Override
    public boolean retry(ITestResult result){
        //从config.properties中读取重跑次数
        CommonTools commonTools = new CommonTools();
        maxRetryCount = Integer.parseInt(commonTools.getConfigData("RetryCount"));

        if (retryCount < maxRetryCount){
            retryCount++;
            System.setProperty("isRetry","true"); //设置全局变量用户判断当前是否为重跑
            return true;
        }else {
            return false;
        }
    }
}

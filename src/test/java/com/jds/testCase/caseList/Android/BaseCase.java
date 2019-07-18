package com.jds.testCase.caseList.Android;

import com.jds.testBase.page.Android.HomePage;
import com.jds.testBase.page.Android.LoginPage;
import com.jds.testBase.page.Android.MinePage;
import com.jds.testBase.page.Android.PersonalPage;
import com.jds.testBase.util.Android.PageAction;
import org.testng.annotations.*;

/**
 * 测试用例基类
 * BeforeSuite:创建本地目录用于保存日志和截图
 * BeforeClass:每个Class(以页面为纬度)执行前重启APP
 */
public class BaseCase {
    static HomePage homePage;
    static MinePage minePage;
    static LoginPage loginPage;
    static PersonalPage personalPage;

    @BeforeSuite(description = "创建截图及日志目录")
    public void creatPath(){
        PageAction.createSavePath();
        System.out.println("-------------------------------创建截图及日志目录");
    }

    @Parameters({"port","udid"})
    @BeforeClass(description = "启动APP")
    public void start(String port,String udid) throws Exception{
        //homePage = PageAction.startAPP(port,udid);
    }

    /**
     * 各页面用例Class覆写此方法
     */
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){}

    /**
     * 执行用例前判断是否为重跑
     */
    @Parameters({"port","udid"})
    @BeforeMethod(description = "检查是否重跑")
    public void resetPage(String port,String udid) throws Exception{
        String isRetry = System.getProperty("isRetry");  //获取是否重跑,RFailRetry将isRetry置为true
        if (isRetry == "true"){
            start(port,udid);  //若为重跑，重启+重新进入被测页面
            pageEntry();
        }
        System.setProperty("isRetry","false"); //　重置页面后重置状态
    }

    @AfterClass(description = "退出APP")
    public void close(){
        PageAction.closeApp();
    }
}

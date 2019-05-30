package com.jds.testCase.caseList.Android;

import com.jds.testBase.page.Android.HomePage;
import com.jds.testBase.page.Android.LoginPage;
import com.jds.testBase.page.Android.MinePage;
import com.jds.testBase.util.Android.PageAction;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/**
 * 测试用例基类
 * BeforeSuite:创建本地目录用于保存日志和截图
 * BeforeClass:每个Class(以页面为纬度)执行前重启APP
 */
public class BaseCase {
    static HomePage homePage;
    static MinePage minePage;
    static LoginPage loginPage;

    @BeforeSuite(description = "创建截图及日志目录")
    public void creatPath(){
        PageAction.createSavePath();
    }

    @Parameters({"port","udid"})
    @BeforeClass(description = "启动APP")
    public void goToHome(String port,String udid) throws Exception{
        homePage = PageAction.startAPP(port, udid);
    }

    @AfterClass(description = "退出APP")
    public void closeApp(){
        PageAction.closeApp();
    }
}

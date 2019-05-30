package com.jds.testCase.caseList.Android;

import com.jds.testBase.util.Android.PageAction;
import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.annotations.*;

public class TestForAndroid extends BaseCase{
    @Story("【模块】首页")
    @Test(groups = {RGroupName.FT,RGroupName.RT}, description = "用例1_进入【我的】并截图")
    public void testCase1() throws Exception{
        minePage = homePage.goToMinePage();
        minePage.PageScreenshot();
    }

    @Story("【模块】首页")
    @Test(groups = {RGroupName.FT,RGroupName.RT}, description = "用例2_点击进入登录页面然后退出APP")
    public void testCase2() throws Exception{
        loginPage = minePage.goToLoginPage();
        PageAction.closeApp();
    }
}

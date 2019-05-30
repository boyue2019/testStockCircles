package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestForAndroid extends BaseCase{
    @Story("【模块】首页")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "用例1_进入【我的】并截图")
    public void testCase1() throws Exception{
        minePage = homePage.goToMinePage();
        minePage.PageScreenshot();
    }

    @Story("【模块】首页")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "用例2_点击进入登录页面然后退出APP")
    public void testCase2() throws Exception{
        loginPage = minePage.goToLoginPage();
    }

    @Story("【模块】首页-查看更多")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "用例3_跳转至资讯列表页面")
    public void testCase3(){
        Assert.assertEquals("1", "2");
    }
}

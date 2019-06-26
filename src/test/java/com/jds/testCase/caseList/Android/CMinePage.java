package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CMinePage extends BaseCase {
    @Override
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
        minePage = homePage.goToMinePage();
    }

    @Story("【模块】我的")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "【用例1】在'我的'页面截图")
    public void testCase2_1() throws Exception{
        minePage.PageScreenshot();  //截图并在报告中展示
    }

    @Story("【模块】我的")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "【用例2】点击进入登录页面")
    public void testCase2_2() throws Exception{
        loginPage = minePage.goToLoginPage();
    }
}

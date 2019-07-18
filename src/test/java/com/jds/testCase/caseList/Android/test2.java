package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test2 extends BaseCase{
    @Override
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
        minePage = homePage.goToMinePage();
    }

    @Story("【模块】我的")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "【用例1】检查登录状态")
    public void testCase1(){
        //Assert.assertEquals(true,minePage.isLogin());
        minePage.PageScreenshot();
    }

    @Story("【模块】我的")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "【用例2】退出登录")
    public void testCase2(){
        personalPage = minePage.gotoPersonalPage();
        personalPage.userLoginOut();
        minePage.PageScreenshot();
    }
}

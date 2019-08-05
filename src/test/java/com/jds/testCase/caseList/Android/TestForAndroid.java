package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.annotations.*;

public class TestForAndroid extends BaseCase{
    @Story("【模块】首页")
    @Test(groups = {RGroupName.CT,RGroupName.RT},description = "用例1_进入【我的】并截图")
    public void testCase1() throws Exception{
        minePage = homePage.goToMinePage();
    }
}
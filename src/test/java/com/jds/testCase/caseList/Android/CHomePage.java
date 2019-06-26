package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CHomePage extends BaseCase {
    @Story("【模块】首页")
    @Test(groups = {RGroupName.FT,RGroupName.RT},description = "【用例1】首页截图")
    public void testCase1_1(){
        Assert.assertEquals("2", "2");
    }
}
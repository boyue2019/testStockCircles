package com.jds.testCase.caseList.Android;

import com.jds.testCase.caseRule.rule.RGroupName;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class test2 {
    @Story("【模块】课程")
    @Test(groups = {RGroupName.FT,RGroupName.RT})
    public void test11(){
        System.out.println("111");
    }
}

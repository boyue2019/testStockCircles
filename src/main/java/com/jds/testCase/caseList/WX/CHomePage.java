package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CHomePage extends BaseCase {
    @Story("【前置】进入解码直播首页")
    @Override
    @BeforeClass
    public void pageEntry() {
        jmHomePage = wxHomePage.openJMZB(); //打开解码直播
    }

    @Story("【测试】进入'每日干货-查看全部'页面")
    @Test
    public void Case001() {
        jmDrycargoPage_ss = jmHomePage.gotoJMDrycargoCheckAll();  //进入每日干货-查看全部
    }
}
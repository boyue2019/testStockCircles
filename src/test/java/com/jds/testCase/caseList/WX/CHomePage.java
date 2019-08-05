package com.jds.testCase.caseList.WX;

import com.jds.testBase.driver.Driver;
import io.qameta.allure.Story;
import org.openqa.selenium.NoSuchElementException;
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
        jmDrycargoPage = jmHomePage.gotoJMDrycargoCheckAll();  //进入每日干货-查看全部
        System.out.println(Driver.getDriverWX().getContext());
        System.out.println(Driver.getDriverWX().findElementByXPath("//*"));
    }
}
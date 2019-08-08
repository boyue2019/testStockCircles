package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CDrycargoPage extends BaseCase {
    @Story("【前置】进入解码直播首页")
    @Override
    @BeforeClass
    public void pageEntry() {
        jmHomePage = wxHomePage.openJMZB();  //打开解码直播
        jmDrycargoPage_ss = jmHomePage.gotoJMDrycargoCheckAll();  //进入每日干货-查看全部
    }

    @Story("【用例001】'每日干货列表'是否包含'师说/为民观天下/财经早班车'TAB")
    @Test
    public void DrycargoPage_Case_001() {
        Assert.assertTrue(jmDrycargoPage_ss.isIncludeArticleType());
    }

    @Story("【用例002】判断'师说'列表至少展示11篇文章")
    @Test
    public void DrycargoPage_Case_002(){
        Assert.assertTrue(jmDrycargoPage_ss.articleCount());
    }

    @Story("【用例003】判断'为民观天下'列表至少展示11篇文章")
    @Test
    public void DrycargoPage_Case_003(){
        jmDrycargoPage_wm = jmDrycargoPage_ss.skipWMGTX();   //跳转至"为民观天下"文章列表
        Assert.assertTrue(jmDrycargoPage_wm.articleCount());
    }

    @Story("【用例004】判断'财经早班车'列表至少展示11篇文章")
    @Test
    public void DrycargoPage_Case_004(){
        jmDrycargoPage_cj = jmDrycargoPage_wm.skipCJZBC();   //跳转至"财经早班车"文章列表
        Assert.assertTrue(jmDrycargoPage_cj.articleCount());
    }
}

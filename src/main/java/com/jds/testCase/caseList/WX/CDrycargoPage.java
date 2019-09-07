package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 每日干货列表测试用例
 */
public class CDrycargoPage extends BaseCase {
    @Story("【前置】进入解码直播首页")
    @Override
    @BeforeClass
    public void pageEntry() {
        jmHomePage.waitWxminiName();
        jmHomePage.jumpHomeWindowHandel();  //切换handel
        jmDrycargoPage_ss = jmHomePage.gotoJMDrycargoCheckAll();  //进入每日干货-查看全部
        jmDrycargoPage_ss.jumpDrycargoWindowHandel();
    }

    @Story("【用例001】检查'每日听干货列表'师说tab是否成功加载")
    @Test
    public void DrycargoPage_Case_001() {
        Assert.assertTrue(jmDrycargoPage_ss.isHaveDrycargoTabSS());
    }

    @Story("【用例002】检查每日听干货列表为民观天下tab是否成功加载")
    @Test
    public void DrycargoPage_Case_002() {
        Assert.assertTrue(jmDrycargoPage_ss.isHaveDrycargoTabWmgtx());
    }

    @Story("【用例003】检查每日听干货列表财经早班车tab是否成功加载")
    @Test
    public void DrycargoPage_Case_003() {
        Assert.assertTrue(jmDrycargoPage_ss.isHaveDrycargoTabCjzbc());
    }

    @Story("【用例004】检查'每日干货列表'的'师说'列表是否至少加载11篇文章")
    @Test
    public void DrycargoPage_Case_004(){
        Assert.assertTrue(jmDrycargoPage_ss.articleCount());
    }

    @Story("【用例005】检查'每日干货列表'的'为民观天下'列表是否至少加载11篇文章")
    @Test
    public void DrycargoPage_Case_005(){
        jmDrycargoPage_wm = jmDrycargoPage_ss.skipWMGTX();   //跳转至"为民观天下"文章列表
        Assert.assertTrue(jmDrycargoPage_wm.articleCount());
    }

    @Story("【用例006】检查'每日干货列表'的'财经早班车'列表是否至少加载11篇文章")
    @Test
    public void DrycargoPage_Case_006(){
        jmDrycargoPage_cj = jmDrycargoPage_wm.skipCJZBC();   //跳转至"财经早班车"文章列表
        Assert.assertTrue(jmDrycargoPage_cj.articleCount());
    }
}

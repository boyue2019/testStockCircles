package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 微课主页测试用例
 */
public class CWeiKePage extends BaseCase{
    @Story("【前置】进入微课主页")
    @Override
    @BeforeClass
    public void pageEntry() {
        jmHomePage.waitWxminiName();
        jmWeiKePage = jmHomePage.goToWeiKePage();
        jmWeiKePage.jumpWeikeWindowHandel();  //切换至包含当前页面元素的handel
    }

    @Story("【用例001】检查'微课列表'至少成功加载4个微课")
    @Test
    public void WeiKePage_Case_001(){
        Assert.assertTrue(jmWeiKePage.isHaveMicroclass());
    }

    @Story("【用例002】检查'微课列表'随意任意微课的主题是否展示正确")
    @Test
    public void WeiKePage_Case_002(){
        Assert.assertTrue(jmWeiKePage.isTrueMicroclassTitle());
    }

    @Story("【用例003】检查'微课列表'随机任意课程是否可以正常跳转")
    @Test
    public void WeiKePage_Case_003(){
        jmWeiKePage.isGoMicroclassDetil();
    }

    @Story("【用例004】检查'微课列表'随意任意微课的简介是否展示正确")
    @Test
    public void WeiKePage_Case_004(){
        Assert.assertTrue(jmWeiKePage.isTrueMicroclassProfile());
    }
}

package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 首页测试用例
 */
public class CHomePage extends BaseCase {
    @Story("【前置】进入解码直播首页")
    @Override
    @BeforeClass
    public void pageEntry() {
        jmHomePage.jumpHomeWindowHandel();  //切换handel
    }

    @Story("【用例001】检查是否存在每日直播标题栏")
    @Test
    public void Case001() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveTitle());
    }

    @Story("【用例002】检查是否存在每日直播查看全部入口")
    @Test
    public void Case002() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveCheckall());
    }

    @Story("【用例003】检查是否存在每日直播入口")
    @Test
    public void Case003() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveEnter());
    }

    @Story("【用例004】检查每日直播栏目名称是否正确")
    @Test
    public void Case004(){
        Assert.assertTrue(jmHomePage.isTrueHomeDailyliveName());
    }

    @Story("【用例005】检查每日直播信息栏正确展示")
    @Test
    public void Case005(){
        Assert.assertTrue(jmHomePage.isTrueHomeDailylivePerson());
    }

    @Story("【用例006】检查每日干货是否展示文章列表")
    @Test
    public void Case006(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoList());
    }

    @Story("【用例007】检查每日干货首篇文章主题正确展示")
    @Test
    public void Case007(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoArticleTitle());
    }

    @Story("【用例008】检查每日干货首篇文章日期格式是否正确")
    @Test
    public void Case008(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoArticleDate());
    }

    @Story("【用例009】检查每日干货第一篇文章是否可以正常跳转")
    @Test
    public void Case009(){
        jmHomePage.isGoHomeDrycargoArticle();
    }

    @Story("【用例010】检查明日投资看点是否存在")
    @Test
    public void Case010() {
        Assert.assertTrue(jmHomePage.isHaveHomeVideoMr());
    }

    @Story("【用例011】检查投资学院是否存在")
    @Test
    public void Case011() {
        jmHomePage.isHaveHomeVideoTz();
    }
}
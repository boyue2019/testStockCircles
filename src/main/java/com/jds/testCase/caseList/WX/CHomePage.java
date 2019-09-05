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

    @Story("【用例001】检查'每日直播'标题栏是否成功加载")
    @Test
    public void Case001() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveTitle());
    }

    @Story("【用例002】检查'每日直播'查看全部入口是否成功加载")
    @Test
    public void Case002() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveCheckall());
    }

    @Story("【用例003】检查'每日直播'入口是否成功加载")
    @Test
    public void Case003() {
        Assert.assertTrue(jmHomePage.isHaveHomeDailyliveEnter());
    }

    @Story("【用例004】检查'每日直播'栏目名称是否正确")
    @Test
    public void Case004(){
        Assert.assertTrue(jmHomePage.isTrueHomeDailyliveName());
    }

    @Story("【用例005】检查'每日直播'信息栏正确展示")
    @Test
    public void Case005(){
        Assert.assertTrue(jmHomePage.isTrueHomeDailylivePerson());
    }

    @Story("【用例006】检查'每日干货'是否展示文章列表")
    @Test
    public void Case006(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoList());
    }

    @Story("【用例007】检查'每日干货'首篇文章主题正确展示")
    @Test
    public void Case007(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoArticleTitle());
    }

    @Story("【用例008】检查'每日干货'首篇文章日期格式是否正确")
    @Test
    public void Case008(){
        Assert.assertTrue(jmHomePage.isHaveHomeDrycargoArticleDate());
    }

    @Story("【用例009】检查'每日干货'随意任意文章是否可以正常跳转")
    @Test
    public void Case009(){
        jmHomePage.isGoHomeDrycargoArticle();
    }

    @Story("【用例010】检查'明日投资'看点是否成功加载")
    @Test
    public void Case010() {
        Assert.assertTrue(jmHomePage.isHaveHomeVideoMr());
    }

    @Story("【用例011】检查'明日投资'看点标题是否正确展示")
    @Test
    public void Case011() {
        Assert.assertTrue(jmHomePage.isTrueHomeVideoMrTitle());
    }

    @Story("【用例012】检查'明日投资'看点查看全部入口是否成功加载")
    @Test
    public void Case012() {
        Assert.assertTrue(jmHomePage.isHaveHomeVideoMrCheckall());
    }

    @Story("【用例013】检查'明日投资'看点任意随机视频标题是否正确展示")
    @Test
    public void Case013() {
        Assert.assertTrue(jmHomePage.isTrueHomeVideoMrVtitle());
    }

    @Story("【用例014】检查'投资学院'是否成功加载")
    @Test
    public void Case014() {
        Assert.assertTrue(jmHomePage.isHaveHomeVideoTz());
    }

    @Story("【用例015】检查'投资学院'标题是否正确展示")
    @Test
    public void Case015() {
        Assert.assertTrue(jmHomePage.isTrueHomeVideoTzTitle());
    }

    @Story("【用例016】检查'投资学院'查看全部入口是否成功加载")
    @Test
    public void Case016() {
        Assert.assertTrue(jmHomePage.isHaveHomeVideoTzCheckall());
    }

    @Story("【用例017】检查'投资学院'任意随机视频标题是否正确展示")
    @Test
    public void Case017() {
        Assert.assertTrue(jmHomePage.isTrueHomeVideoTzVtitle());
    }

    @Story("【用例018】检查'策略直播'title正确展示")
    @Test
    public void Case018() {
        Assert.assertTrue(jmHomePage.isTrueHomeTacticsLiveTitle());
    }

    @Story("【用例019】检查'策略直播'查看全部入口是否成功加载")
    @Test
    public void Case019() {
        Assert.assertTrue(jmHomePage.isHaveHomeTacticsLiveCheckall());
    }

    @Story("【用例020】检查'策略直播'入口是否成功加载")
    @Test
    public void Case020() {
        Assert.assertTrue(jmHomePage.isHaveHomeTacticsLiveEnter());
    }

    @Story("【用例021】检查'策略直播'栏目名称是否正确展示")
    @Test
    public void Case021() {
        Assert.assertTrue(jmHomePage.isTrueHomeTacticsLiveItemname());
    }

    @Story("【用例022】检查'策略直播'观看人数正确展示")
    @Test
    public void Case022() {
        Assert.assertTrue(jmHomePage.isTrueHomeTacticsLivePerson());
    }

}
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
        jmHomePage = wxHomePage.openJMZB(); //打开解码直播
        jmDrycargoPage = jmHomePage.gotoJMDrycargoCheckAll();  //进入每日干货-查看全部
    }

    @Story("【用例001】'每日干货列表'是否包含'师说/为民观天下/财经早班车'TAB")
    @Test
    public void DrycargoPage_Case_001() {
        Assert.assertTrue(jmDrycargoPage.isIncludeArticleType());  //校验:每日干货列表是否包含"师说"Tab元素

    }

    @Story("【测试】进入'每日干货-查看全部'页面")
    @Test
    public void DrycargoPage_Case_002(){
        System.out.println("文章数量:" + jmDrycargoPage.articleCount());
    }
}

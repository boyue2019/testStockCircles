package com.jds.testCase.caseList.WX;

import io.qameta.allure.Story;
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
        jmWeiKePage = jmHomePage.goToWeiKePage();
    }

    @Story("【用例001】进入微课主页")
    @Test
    public void WeiKePage_Case_001(){
        System.out.println("成功进入微课主页.");
    }
}

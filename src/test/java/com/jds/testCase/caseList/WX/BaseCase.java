package com.jds.testCase.caseList.WX;

import com.jds.testBase.page.WX.JMZB.*;
import com.jds.testBase.util.Android.PageAction;
import org.testng.annotations.BeforeClass;

public class BaseCase {
    static WXHomePage wxHomePage;
    static JMHomePage jmHomePage;
    static JMMinePage jmMinePage;
    static JMDrycargoPage jmDrycargoPage;

    /**
     * 启动微信
     */
    @BeforeClass(description = "【前置】启动微信")
    public void startWX(){
        wxHomePage = PageAction.startWX();
    }

    /**
     * 各页面用例Class覆写此方法
     */
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
    }
}

package com.jds.testCase.caseList.WX;

import com.jds.testBase.appium.AppiumDriver;
import com.jds.testBase.page.WX.JMZB.*;
import com.jds.testBase.util.PageAction;
import com.jds.testBase.yaml.ModelFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseCase {
    static WXHomePage wxHomePage;
    static JMHomePage jmHomePage;
    static JMDrycargoPage jmDrycargoPage_ss;
    static JMDrycargoPage jmDrycargoPage_wm;
    static JMDrycargoPage jmDrycargoPage_cj;

    /**
     * 启动Appium服务,微信
     */
    @BeforeSuite
    public void startWX(){
        //ModelFactory modelFactory = new ModelFactory();
        //modelFactory.MakeModel();     //采集设备信息并生成yaml文件
        AppiumDriver.startServer();
        wxHomePage = PageAction.startWX();
    }

    /**
     * 各页面用例Class覆写此方法
     */
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
    }

    /**
     * 返回首页或重启WX
     */
    @AfterClass
    public void goHome(){
        try {
            PageAction.goBack(); //class结束后返回首页
        }catch (Exception e){
            wxHomePage = PageAction.startWX();  //若返回首页失败，重启WX
        }

    }

    /**
     * 关闭微信,Appium服务
     */
    @AfterSuite
    public void closeWX(){
        PageAction.closeWX();   //退出微信
        AppiumDriver.stopServer();   //关闭Appium服务
    }
}

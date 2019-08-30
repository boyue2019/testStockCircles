package com.jds.testCase.caseList.WX;

import com.jds.testBase.appium.AppiumDriver;
import com.jds.testBase.driver.Driver;
import com.jds.testBase.page.WX.JMZB.*;
import com.jds.testBase.util.PageAction;
import org.testng.annotations.*;

public class BaseCase {
    public static ThreadLocal<Driver> ThreadDriver = new ThreadLocal<Driver>();
    public WXHomePage wxHomePage;
    public JMHomePage jmHomePage;
    public JMWeiKePage jmWeiKePage;
    public JMDrycargoPage jmDrycargoPage_ss;
    public JMDrycargoPage jmDrycargoPage_wm;
    public JMDrycargoPage jmDrycargoPage_cj;
    
    /**
     * 启动Appium服务,微信
     */
    @BeforeTest
    @Parameters({"port","bp","chromedrniverport","system","serial","height","width","manufacturer","model","version"})
    public void begin(String port,
                      String bp,
                      String chromedrniverport,
                      String system,
                      String serial,
                      String height,
                      String width,
                      String manufacturer,
                      String model,
                      String version){
        AppiumDriver.startServer(port,bp);
        Driver driver = new Driver();
        ThreadDriver.set(driver);
        wxHomePage = PageAction.startWX();
        jmHomePage = wxHomePage.openJMZB();  //打开解码直播
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
    public void gohome(){
        try {
            System.out.println("返回首页.");
            PageAction.goBack(); //class结束后返回首页
        }catch (Exception e){
            System.out.println("重新启动小程序.");
            wxHomePage = PageAction.startWX();  //若返回首页失败，重启WX
        }

    }

    /**
     * 关闭微信,Appium服务
     */
    @AfterSuite
    public void over(){
        PageAction.closeWX();   //退出微信
        //AppiumDriver.stopServer();   //关闭Appium服务
    }
}

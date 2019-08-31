package com.jds.testCase.caseList.WX;

import com.jds.testBase.appium.AppiumDriver;
import com.jds.testBase.driver.Driver;
import com.jds.testBase.page.WX.JMZB.*;
import com.jds.testBase.util.CommonTools;
import com.jds.testBase.util.PageAction;
import org.testng.annotations.*;

public class BaseCase {
    public static ThreadLocal<Driver> ThreadDriver = new ThreadLocal<Driver>();
    String ExperimentalOption = CommonTools.getConfigData("ExperimentalOption");
    static WXHomePage wxHomePage;
    static JMHomePage jmHomePage;
    static JMWeiKePage jmWeiKePage;
    static JMDrycargoPage jmDrycargoPage_ss;
    static JMDrycargoPage jmDrycargoPage_wm;
    static JMDrycargoPage jmDrycargoPage_cj;
    
    /**
     * 1.启动Appium服务
     * 2.打开微信小程序
     */
    @BeforeTest
    @Parameters({"port","bp","chromedrniverport","system","serial","height","width","manufacturer","model","version"})
    public void openWxMini(String port,
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
        wxHomePage = PageAction.startWX(port, serial, system, version, ExperimentalOption);
        jmHomePage = wxHomePage.openJMZB();  //打开解码直播
    }

    /**
     * 进入被测页面
     * 备注:在各测试Class中重写
     */
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
    }

    /**
     * 每个Class用例执行结束后返回首页或重新进入小程序
     */
    @AfterClass
    @Parameters({"port","bp","chromedrniverport","system","serial","height","width","manufacturer","model","version"})
    public void goHome(String port,
                       String bp,
                       String chromedrniverport,
                       String system,
                       String serial,
                       String height,
                       String width,
                       String manufacturer,
                       String model,
                       String version){
        try {
            System.out.println("返回首页.");
            PageAction.goBack(); //class结束后返回首页
        }catch (Exception e){
            System.out.println("重新启动小程序.");
        }
    }

    /**
     * 关闭微信
     */
    @AfterTest
    public void closeWxMini(){
        PageAction.closeWX();
    }

    /**
     * 关闭Appium服务
     */
    @AfterSuite
    public void stopAppium(){
        AppiumDriver.stopServer();
    }
}

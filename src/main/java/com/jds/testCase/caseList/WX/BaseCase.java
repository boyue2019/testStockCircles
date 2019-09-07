package com.jds.testCase.caseList.WX;

import com.jds.testBase.appium.AppiumDriver;
import com.jds.testBase.driver.Driver;
import com.jds.testBase.page.WX.JMZB.*;
import com.jds.testBase.util.CommonTools;
import com.jds.testBase.util.PageAction;
import org.testng.annotations.*;

public class BaseCase {
    public static ThreadLocal<Driver> ThreadDriver = new ThreadLocal<Driver>();
    public static ThreadLocal<String> ThreadHeight = new ThreadLocal<>();
    public static ThreadLocal<String> ThreadWidth = new ThreadLocal<>();

    static WXHomePage wxHomePage;
    static JMHomePage jmHomePage;
    static JMWeiKePage jmWeiKePage;
    static JMDrycargoPage jmDrycargoPage_ss;
    static JMDrycargoPage jmDrycargoPage_wm;
    static JMDrycargoPage jmDrycargoPage_cj;
    
    /**
     * 启动Appium服务后打开小程序
     */
    @BeforeTest
    @Parameters({"port","bp","system","serial","height", "width", "manufacturer","model","version"})
    public void openWxMini(String port,    //Appium端口
                           String bp,      //Bootstrap端口
                           String system,  //设备系统
                           String serial,  //设备号
                           String height,  //设备屏幕高度
                           String width,   //设备屏幕宽度
                           String manufacturer,   //厂商
                           String model,          //机型
                           String version){       //系统版本
        //启动Appium服务
        AppiumDriver.startAppiumServer(port,bp);
        Driver driver = new Driver();
        ThreadDriver.set(driver);
        ThreadHeight.set(height);
        ThreadWidth.set(width);

        //启动微信
        wxHomePage = PageAction.startWX(port, serial,
                system, version, CommonTools.getCommonTools().getConfigData("ExperimentalOption"));
        //打开解码直播小程序
        jmHomePage = wxHomePage.openJMZB();
    }

    /**
     * 进入被测页面
     * 备注:在各测试Class中重写
     */
    @BeforeClass(description = "进入测试页面")
    public void pageEntry(){
    }

    /**
     * 每个Class用例执行结束后返回首页
     */
    @AfterClass
    public void goHome(){
        BasePage.goBackHome();
        jmHomePage = BasePage.goToHomePage();
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
        AppiumDriver.stopAppiumServer();
    }
}

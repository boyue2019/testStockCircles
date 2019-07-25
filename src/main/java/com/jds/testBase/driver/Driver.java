package com.jds.testBase.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static AndroidDriver<AndroidElement> driverAN = null;
    public static IOSDriver<IOSElement> driverIOS = null;

    public static void startAN(String port,String udid){
        DesiredCapabilities desiredCapabilities =  new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName",udid);   //设备ID
        desiredCapabilities.setCapability("platformName","Android");    //测试平台
        desiredCapabilities.setCapability("platformVersion","6.0");     //Android版本
        desiredCapabilities.setCapability("appPackage","com.jindashi.stockcircle");   //APP包名
        desiredCapabilities.setCapability("appActivity","com.jindashi.stockcircle.business.common.activity.SplashingActivity"); //ActivityName
        desiredCapabilities.setCapability("unicodeKeyboard","True");
        desiredCapabilities.setCapability("resetKeyboard","True");
        desiredCapabilities.setCapability("noSign","True");
        desiredCapabilities.setCapability("noReset","True");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:" + port +"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverAN = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
    }

    public static void startIOS(String port,String udid){
        DesiredCapabilities dc =  new DesiredCapabilities();
        dc.setCapability("platformName","iOS");//启动哪种设备，模拟器或者真机
        dc.setCapability("platformVersion","12.1.2");//使用哪种自动化
        dc.setCapability("deviceName","iPhone");//设备名称
        dc.setCapability("app","com.fdzq.ForthrightSecurities-Dev2");//BundleId
        dc.setCapability("udid",udid);//IOS设备ID - idevice_id -l
        dc.setCapability("automationName","XCUITest");
        dc.setCapability("unicodeKeyboard","True");
        dc.setCapability("resetKeyboard","True");
        dc.setCapability("noSign","True");
        dc.setCapability("noReset","True");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:" + port +"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverIOS = new IOSDriver<IOSElement>(remoteUrl, dc);
        //driverIOS.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static AndroidDriver<AndroidElement> getDriverAN(){
        return driverAN;
    }

    public static IOSDriver<IOSElement> getDriverIOS(){
        return driverIOS;
    }
}

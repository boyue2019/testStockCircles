package com.jds.testBase.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    public static AndroidDriver<AndroidElement> driverAN = null;
    public static AndroidDriver<AndroidElement> driverWX = null;
    public static IOSDriver<IOSElement> driverIOS = null;

    public static AndroidDriver<AndroidElement> getDriverWX() {
        return driverWX;
    }

    public static void setDriverWX(AndroidDriver<AndroidElement> driverWX) {
        Driver.driverWX = driverWX;
    }

    public static AndroidDriver<AndroidElement> getDriverAN(){
        return driverAN;
    }

    public static IOSDriver<IOSElement> getDriverIOS(){
        return driverIOS;
    }

    public static void startWX(String port,
                               String udid,
                               String platformName,
                               String version,
                               String ExperimentalOption){
        DesiredCapabilities cap =  new DesiredCapabilities();
        cap.setCapability("deviceName",udid);   //设备ID
        cap.setCapability("platformName",platformName);    //测试平台
        cap.setCapability("platformVersion",version);     //Android版本
        cap.setCapability("appPackage","com.tencent.mm");   //APP包名
        cap.setCapability("appActivity","com.tencent.mm.ui.LauncherUI"); //ActivityName
        cap.setCapability("appWaitActivity", "com.tencent.mm.app.WeChatSplashActivity");
        cap.setCapability("newCommandTimeout","120");
        cap.setCapability("unicodeKeyboard",true);
        cap.setCapability("resetKeyboard",true);
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noSign",true);
        cap.setCapability("noReset",true);
        cap.setCapability("recreateChromeDriverSessions", true);

        File chromedriver = new File(System.getProperty("user.dir") + "/chromedriver");
        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,chromedriver.getAbsolutePath());

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidProcess", ExperimentalOption);
        cap.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        cap.setBrowserName("");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:" + port +"/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driverWX = new AndroidDriver<AndroidElement>(remoteUrl, cap);
    }

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
}

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
    public AndroidDriver<AndroidElement> driverWX = null;

    public void setDriverWX(AndroidDriver<AndroidElement> driverWX) {
        this.driverWX = driverWX;
    }

    public AndroidDriver<AndroidElement> getDriverWX() {
        return driverWX;
    }

    /**
     * 启动微信,返回driver
     * @param port appium端口
     * @param udid 设备id
     * @param platformName 设备系统
     * @param version      系统版本
     * @param ExperimentalOption 被测小程序进程名称
     */
    public void startWX(String port,
                               String udid,
                               String platformName,
                               String version,
                               String ExperimentalOption){
        DesiredCapabilities cap =  new DesiredCapabilities();
        cap.setCapability("deviceName",udid);   //设备ID
        cap.setCapability("platformName",platformName);    //测试平台
        cap.setCapability("platformVersion",version);     //Android版本
        cap.setCapability("appPackage","com.tencent.mm");   //APP包名
        cap.setCapability("appActivity","com.tencent.mm.ui.LauncherUI"); //ActivityName:微信
        cap.setCapability("appWaitActivity", "com.tencent.mm.app.WeChatSplashActivity");  //等待页
        cap.setCapability("newCommandTimeout","120");
        cap.setCapability("unicodeKeyboard",true);
        cap.setCapability("resetKeyboard",true);
        cap.setCapability("sessionOverride", true);
        cap.setCapability("noSign",true);
        cap.setCapability("noReset",true);
        cap.setCapability("recreateChromeDriverSessions", true);

        File chromedriver = new File(System.getProperty("user.dir") + "/chromedriver");  //加载chrome驱动
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
        setDriverWX(driverWX);
    }

    /**
     * 关闭微信
     */
    public void closeWX(){
        driverWX.close();
    }
}

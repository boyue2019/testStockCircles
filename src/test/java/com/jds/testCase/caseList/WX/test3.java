package com.jds.testCase.caseList.WX;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class test3 {
    @Test
    public void Test(){
        AndroidDriver driver;
        DesiredCapabilities cap =  new DesiredCapabilities();
        cap.setCapability("deviceName","edd06f8e");   //设备ID
        cap.setCapability("platformName","Android");    //测试平台
        cap.setCapability("platformVersion","6.0");     //Android版本
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
        //cap.setCapability("autoWebview",true);

        File chromedriver = new File(System.getProperty("user.dir") + "/chromedriver");
        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,chromedriver.getAbsolutePath());

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("androidProcess", "com.tencent.mm:appbrand0");
        cap.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        cap.setBrowserName("");

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver<AndroidElement>(remoteUrl, cap);

        try{
            Thread.sleep(8000);
        }catch (InterruptedException e){

        }

        System.out.println(driver.findElementByXPath("//*[@text='通讯录']").isDisplayed());


        new TouchAction(driver)
                .press(PointOption.point(500,733))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(500,1800))
                .release().perform();

        try{
            Thread.sleep(6000);
        }catch (InterruptedException e) {
        }

        driver.findElementByXPath("//*[@text='解码直播']").click();

        try{
            Thread.sleep(20000);
        }catch (InterruptedException e) {
        }

        driver.context("WEBVIEW_com.tencent.mm:appbrand0");


        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            System.out.println("所有WindowHandle" + driver.getWindowHandles());
            System.out.println("当前context:" + driver.getContext());
            System.out.println("所有context:" + driver.getContextHandles());
            //System.out.println(driver.getPageSource());
            try{
                System.out.println("是否包含底导元素:" + driver.findElementByXPath("//*[@text='首页']").isDisplayed());
            }
            catch (NoSuchElementException n){
                System.out.println("找不到指定元素.");
            }
        }

        driver.context("NATIVE_APP");

        try{
            System.out.println("是否包含底导元素:" + driver.findElementByXPath("//*[@text='首页']").isDisplayed());
        }
        catch (NoSuchElementException n){
            System.out.println("找不到指定元素.");
        }
        //driver.findElementByXPath("/html/body/wx-view/wx-view[1]/wx-form/span/wx-button").click();
        //driver.quit();
    }
}
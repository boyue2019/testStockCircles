package com.jds.testBase.util;

import com.jds.testBase.page.WX.JMZB.BasePage;
import com.jds.testBase.page.WX.JMZB.WXHomePage;
import com.jds.testCase.caseList.WX.BaseCase;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

/**
 * Page事件类
 */
public class PageAction {
    /**
     * 启动微信
     * @return
     */
    @Step("【系统】启动微信解码直播小程序")
    public static WXHomePage startWX(String port,String udid,String platformName,String version,String ExperimentalOption){
        try{
            System.out.println("启动微信.");
            BaseCase.ThreadDriver.get().startWX(port, udid, platformName, version, ExperimentalOption);
            return new WXHomePage();      //返回微信首页对象
        }catch (Exception e){
            System.out.println("微信启动失败.");
            return null;
        }
    }

    /**
     * 退出WX
     */
    @Step("【系统】退出微信")
    public static void closeWX(){
        switchToNative(); //先切换至NATIVE
        System.out.println("退出微信.");
        BaseCase.ThreadDriver.get().getDriverWX().quit();
    }

    /**
     * 元素名称处理
     * @param element
     * @return
     */
    public static String subStringElement(WebElement element){
        try{
            String elementString1 = element.
                    toString().
                    substring(element.toString().lastIndexOf("id: "));
            String elementString2 = elementString1.
                    substring(0,elementString1.length() -1);
            return elementString2;
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 等待元素出现后点击
     * @param TIMEOUT 设置超时时间
     * @param element 元素
     */
    public static void click(int TIMEOUT,WebElement element){
        try{
            waitElement(TIMEOUT, element);
            System.out.println("点击元素.");
            element.click();  //点击指定元素
        }catch (NoSuchElementException n){  //若找不到元素退出程序
            System.out.println("找不到对应元素;【Method】skiclickpWMGTX");
            System.exit(0);
        }
    }

    /**
     * 判断元素是否存在
     * @param element
     * @return
     */
    public static boolean isElementExist(WebElement element){
        try{
            if (element.isDisplayed() == true){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 等待元素出现
     * @param TIMEOUT 超时时间
     * @param element @FindBy标签元素
     */
    public static void waitElement(int TIMEOUT,WebElement element){
        try{
            new WebDriverWait(BaseCase.ThreadDriver.get().getDriverWX(),TIMEOUT).
                    until(new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver driver){
                            Boolean isExist = element.isDisplayed();
                            return isExist;
                        }
                    });
        }catch (TimeoutException te){
            System.out.println("等待超时.");
        }
    }

    /**
     * 截图(等待元素出现后)
     * @param TIMEOUT
     * @param element
     */
    public static void waitElementScreenshot(int TIMEOUT, WebElement element){
        Date date = new Date();
        SimpleDateFormat screen_name = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String screenName = screen_name.format(date.getTime());   //获取精确时间

        //从系统变量中获取截图路径
        File savePath = new File(System.getProperty("savePicPath"));

        //等待元素出现
        waitElement(TIMEOUT,element);

        //App截屏
        try{
            File screenFile = BaseCase.ThreadDriver.get().
                    getDriverWX().
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenFile,new File(savePath + "/" + screenName + ".jpg"));
            //Log4jUtils.logInfo("截图成功:" + savePath + "/" + screenName + ".jpg");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 截图(非等待)
     */
    public static byte[] screenshot(){
        Date date = new Date();
        SimpleDateFormat screen_name = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String screenName = screen_name.format(date.getTime());   //获取执行时间

        File savePath = new File(System.getProperty("savePicPath")); //从系统变量中获取截图路径(BeforeSuite

        //App截屏
        try{
            File screenFile = BaseCase.ThreadDriver.get().getDriverWX().getScreenshotAs(OutputType.FILE);  //保存本地
            byte[] screenShot = BaseCase.ThreadDriver.get().getDriverWX().getScreenshotAs(OutputType.BYTES);  //返回screenShot,用于上传Allure附件
            FileUtils.copyFile(screenFile,new File(savePath + "/" + screenName + ".jpg"));
            //Log4jUtils.logInfo("截图成功:" + savePath + "/" + screenName + ".jpg");
            return screenShot;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 滑动屏幕
     * @param px 按压x坐标(屏宽百分比) px=(x*100)/总屏宽
     * @param py 按压y坐标(屏高百分比) py=(y*100)/总屏高
     * @param mx 终点x坐标(屏宽百分比)
     * @param my 终点y坐标(屏高百分比)
     */
    public static void slide(int px,int py,int mx,int my){
        int x1 = (1080 * px) / 100;
        int y1 = (1920 * py) / 100;
        int x2 = (1080 * mx) / 100;
        int y2 = (1920 * my) / 100;
        new TouchAction(BaseCase.ThreadDriver.get().getDriverWX())     //滑动屏幕
                .press(PointOption.point(x1,y1))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(x2,y2))
                .release().perform();
    }

    /**
     * 切换至'WEBVIEW_com.tencent.mm:appbrand0'
     */
    public static void switchToWebview(){
        //若当前context不是webview则切换至webview
        if(!BaseCase.ThreadDriver.get().getDriverWX().getContext().equals("WEBVIEW_com.tencent.mm:appbrand0")){
            System.out.println("切换至WebView.");
            BaseCase.ThreadDriver.get().getDriverWX().context("WEBVIEW_com.tencent.mm:appbrand0");
        }else {
            System.out.println("当前Context:WEBVIEW_com.tencent.mm:appbrand0");
        }
    }

    /**
     * 切换至'NATIVE_APP'
     */
    public static void switchToNative(){
        if(!BaseCase.ThreadDriver.get().getDriverWX().getContext().equals("NATIVE_APP")){
            System.out.println("切换至NATIVE.");
            BaseCase.ThreadDriver.get().getDriverWX().context("NATIVE_APP");
        }else {
            System.out.println("当前Context:NATIVE_APP");
        }
    }

    /**
     * 【WebView】切换至包含指定元素的WindowHandle
     * @param element
     */
    public static Boolean jumpToWindowHandel(WebElement element){
        Boolean isHave = false;
        for(String handle : BaseCase.ThreadDriver.get().getDriverWX().getWindowHandles()){
            BaseCase.ThreadDriver.get().getDriverWX().switchTo().window(handle);  //遍历handel直到找到相应元素
            waitElement(10,element);
            try{
                if (element.isDisplayed()){
                    System.out.println("找到对应元素;当前WindowHandle:" + handle);
                    isHave = true;
                    break;
                }
            }catch (NoSuchElementException | StaleElementReferenceException n){
                System.out.println("未找到对应元素或页面元素过时;当前WindowHandle:" + handle);
                isHave = false;
            }
        }
        return isHave;
    }

    /**
     * 返回首页
     */
    public static void goBack(){
        BasePage.goBack();
    }
}
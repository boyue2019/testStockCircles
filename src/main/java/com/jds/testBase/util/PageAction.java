package com.jds.testBase.util;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.log.Log4jUtils;
import com.jds.testBase.page.WX.JMZB.WXHomePage;
import com.jds.testBase.yaml.ModelBean;
import com.jds.testBase.yaml.ModelRead;
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
    @Step("【系统】启动微信小程序")
    public static WXHomePage startWX(){
        ModelRead read = new ModelRead();
        ModelBean bean = read.ReadYaml();   //读取docker-compose.yaml文件
        Map dp = new HashMap();             //获取driver所需信息后添加到map
        dp.put("port",bean.getModeldetails().get(0).getAppiumParameters().getPort());   //appium端口
        dp.put("udid",bean.getModeldetails().get(0).getSerial());                       //设备号
        dp.put("platformName",bean.getModeldetails().get(0).getSystem());               //Android/iOS
        dp.put("version",bean.getModeldetails().get(0).getDeviceInfos().getVersion());  //手机系统版本
        dp.put("ExperimentalOption",CommonTools.getConfigData("ExperimentalOption"));   //被测小程序进程名称
        try{
            System.out.println("启动微信.");
            Driver.startWX(dp.get("port").toString(),
                    dp.get("udid").toString(),
                    dp.get("platformName").toString(),
                    dp.get("version").toString(),
                    dp.get("ExperimentalOption").toString());
            return new WXHomePage();      //返回微信首页对象
        }catch (Exception e){
            System.out.println("微信启动失败.");
            return null;
        }
    }

    /**
     * 退出WX
     */
    @Step("【系统】退出APP")
    public static void closeWX(){
        PageAction.switchToNative(); //先切换至NATIVE
        System.out.println("退出微信.");
        Driver.getDriverWX().quit();
    }

    /**
     * 启动APP
     * @param port
     * @param udid
     * @return
     */
    @Step("【系统】启动APP")
    public static void start(String port, String udid){
        try{
            Log4jUtils.logDebug("启动投资易课APP");
            Driver.startAN(port, udid);
        }catch (Exception e){
            Log4jUtils.logError("投资易课APP启动失败");
            Log4jUtils.logError(e.toString());
        }
    }

    /**
     * 退出APP
     */
    @Step("【系统】退出APP")
    public static void close(){
        System.out.println("退出APP");
        Driver.getDriverAN().quit();
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
    public static void click(int TIMEOUT,WebElement element,String target){
        try{
            waitElement(TIMEOUT, element,target);
            System.out.println("点击元素.");
            element.click();  //点击指定元素
        }catch (Exception e){  //若找不到元素退出程序
            System.out.println("找不到元素.");
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
    public static void waitElement(int TIMEOUT,WebElement element,String target){
        if (target == "app"){
            try{
                new WebDriverWait(Driver.getDriverAN(),TIMEOUT).
                        until(new ExpectedCondition<Boolean>(){
                            @Override
                            public Boolean apply(WebDriver driver){
                                //System.out.println("等待APP元素...");
                                Boolean isExist = element.isDisplayed();
                                return isExist;
                            }
                        });
            }catch (TimeoutException te){
                System.out.println("等待超时.");
            }
        }else{
            try{
                new WebDriverWait(Driver.getDriverWX(),TIMEOUT).
                        until(new ExpectedCondition<Boolean>(){
                            @Override
                            public Boolean apply(WebDriver driver){
                                //System.out.println("等待WX元素...");
                                Boolean isExist = element.isDisplayed();
                                return isExist;
                            }
                        });
            }catch (TimeoutException te){
                System.out.println("等待超时.");
            }
        }
    }

    /**
     * 截图(等待元素出现后)
     * @param TIMEOUT
     * @param element
     */
    public static void waitElementScreenshot(int TIMEOUT, WebElement element,String target){
        Date date = new Date();
        SimpleDateFormat screen_name = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String screenName = screen_name.format(date.getTime());   //获取精确时间

        //从系统变量中获取截图路径
        File savePath = new File(System.getProperty("savePicPath"));

        //等待元素出现
        waitElement(TIMEOUT,element,target);

        //App截屏
        try{
            File screenFile = Driver.
                    getDriverAN().
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
            File screenFile = Driver.getDriverAN().getScreenshotAs(OutputType.FILE);  //保存本地
            byte[] screenShot = Driver.getDriverAN().getScreenshotAs(OutputType.BYTES);  //返回screenShot,用于上传Allure附件
            FileUtils.copyFile(screenFile,new File(savePath + "/" + screenName + ".jpg"));
            //Log4jUtils.logInfo("截图成功:" + savePath + "/" + screenName + ".jpg");
            return screenShot;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 等待元素出现后滑动屏幕
     * @param TIMEOUT 超时时间
     * @param px 点击x坐标
     * @param py 点击y坐标
     * @param mx 重点x坐标
     * @param my
     */
    public static void slide(int TIMEOUT,int px,int py,int mx,int my){
        new TouchAction(Driver.getDriverWX())     //滑动屏幕
                .press(PointOption.point(px,py))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(mx,my))
                .release().perform();
    }

    /**
     * 切换至'WEBVIEW_com.tencent.mm:appbrand0'
     */
    public static void switchToWebview(){
        //若当前context不是webview则切换至webview
        if(!Driver.getDriverWX().getContext().toString().equals("WEBVIEW_com.tencent.mm:appbrand0")){
            System.out.println("切换至WebView.");
            Driver.getDriverWX().context("WEBVIEW_com.tencent.mm:appbrand0");
        }else {
            System.out.println("当前Context:WEBVIEW_com.tencent.mm:appbrand0");
        }
    }

    /**
     * 切换至'NATIVE_APP'
     */
    public static void switchToNative(){
        if(!Driver.getDriverWX().getContext().toString().equals("NATIVE_APP")){
            System.out.println("切换至NATIVE.");
            Driver.getDriverWX().context("NATIVE_APP");
        }else {
            System.out.println("当前Context:NATIVE_APP");
        }
    }

    /**
     * 【WebView】切换至包含指定元素的WindowHandle
     * @param element
     */
    public static Boolean jumpToWindowHandel(WebElement element){
        Boolean isHave;
        for(String handle : Driver.getDriverWX().getWindowHandles()){

            Driver.getDriverWX().switchTo().window(handle);  //遍历handel直到找到相应元素
            try{
                if (element.isDisplayed()){
                    System.out.println("找到对应元素;当前WindowHandle:" + handle);
                    isHave = true;
                    break;
                }
            }catch (NoSuchElementException n){
                System.out.println("未找到对应元素;当前WindowHandle:" + handle);
                isHave = false;
            }
        }
        return true;
    }
}
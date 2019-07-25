package com.jds.testBase.util.Android;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.log.Log4jUtils;
import com.jds.testBase.page.Android.HomePage;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PageAction {
    /**
     * 启动APP
     * @param port
     * @param udid
     * @return
     */
    @Step("【系统】启动APP")
    public static HomePage start(String port, String udid){
        try{
            Log4jUtils.logInfo("启动投资易课APP");
            Driver.startAN(port, udid);
            return new HomePage();
        }catch (Exception e){
            Log4jUtils.logError("投资易课APP启动失败");
            Log4jUtils.logError(e.toString());
            return null;
        }
    }

    /**
     * 退出APP
     */
    @Step("【系统】退出APP")
    public static void close(){
        Log4jUtils.logInfo("退出投资易课APP");
        Driver.getDriverAN().quit();
    }

    /**
     * 元素名称处理
     * @param element
     * @return
     */
    public static String subStringElement(WebElement element){
        try{
            System.out.println(element.toString());
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
            Log4jUtils.logInfo("点击元素:" + subStringElement(element));
            element.click();  //点击指定元素
        }catch (NoSuchElementException ns){  //若找不到元素捕获异常
            Log4jUtils.logWarn("找不到元素:" + subStringElement(element));
            Log4jUtils.logWarn(ns.toString());
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
            new WebDriverWait(Driver.getDriverAN(),TIMEOUT).
                    until(new ExpectedCondition<Boolean>(){
                        @Override
                        public Boolean apply(WebDriver driver){
                            Log4jUtils.logInfo("等待元素:" + subStringElement(element));
                            Boolean isExist = element.isDisplayed();
                            return isExist;
                        }
                    });
        }catch (TimeoutException te){
            Log4jUtils.logWarn("等待超时.");
            Log4jUtils.logWarn(te.toString());
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
            File screenFile = Driver.
                    getDriverAN().
                    getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenFile,new File(savePath + "/" + screenName + ".jpg"));
            Log4jUtils.logInfo("截图成功:" + savePath + "/" + screenName + ".jpg");
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
            Log4jUtils.logInfo("截图成功:" + savePath + "/" + screenName + ".jpg");
            return screenShot;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 屏幕点击坐标 - Android
     * @param x
     * @param y
     */
    public static void touchAndroid(int x,int y){
        AndroidTouchAction action = new AndroidTouchAction(Driver.getDriverAN());
        action.press(PointOption.point(x,y));
    }

    /**
     * 屏幕点击坐标 - IOS
     * @param x
     * @param y
     */
    public static void touchIOS(int x,int y){
        IOSTouchAction action = new IOSTouchAction(Driver.getDriverIOS());
        action.press(PointOption.point(x,y));
    }

    /**
     * 创建截图、日志目录
     */
    public static void createSavePath(){
        Date date = new Date();
        SimpleDateFormat datePath = new SimpleDateFormat("yyyy-MM-dd");
        String datePathName = datePath.format(date.getTime());       //获取日期
        SimpleDateFormat timePath = new SimpleDateFormat("HH_mm_ss");
        String timePathName = timePath.format(date.getTime());       //获取时间
        SimpleDateFormat fileName = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String logName = fileName.format(date.getTime());            //获取精确时间

        //创建截图目录：文件夹名称为当天日期
        File savePicPath = new File("/Users/boyue/工作/StockCircles/ScreenShot/" + datePathName + "/" + timePathName + "/");
        if(!savePicPath.exists()){
            savePicPath.mkdirs();  //不存在则创建当日文件夹
            System.setProperty("savePicPath",savePicPath.toString());  //设置截图保存路径
        }else {
        }

        //创建日志目录：文件夹名称为当天日期
        File saveLogPath = new File("/Users/boyue/工作/StockCircles/Log/" + datePathName + "/" + timePathName + "/");
        File filelogPath = new File(  "Log/" + datePathName + "/" + timePathName + "/" + logName);
        if(!saveLogPath.exists()){
            saveLogPath.mkdirs();  //不存在则创建当日文件夹
            System.setProperty("logPath",filelogPath.toString());  //设置日志文件名称
            //System.out.println(System.getProperty("logPath"));
        }else {
        }
    }
}

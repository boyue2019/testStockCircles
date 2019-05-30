package com.jds.testBase.page.Android;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.Android.PageAction;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Page基类，提供各页面间重复共
 * 1.PageFactory页面元素初始化  2.页面截图（非等待）
 */
public class BasePage {
    /**
     * 初始化页面元素
     */
    public BasePage(){
        PageFactory.initElements(Driver.getDriverAN(),this);
    }

    /**
     * 页面截图
     */
    @Step("【系统】屏幕截图")
    public void PageScreenshot(){
        PageAction.screenshot();
    }
}

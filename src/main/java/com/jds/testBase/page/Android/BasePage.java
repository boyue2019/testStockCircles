package com.jds.testBase.page.Android;

import com.jds.testBase.driver.Driver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {
    /**
     * 初始化页面元素
     */
    public BasePage(){
        PageFactory.initElements(Driver.getDriverAN(),this);
        //System.out.println("初始化页面.");
    }
}

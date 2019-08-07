package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.PageAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page基类，提供各页面间重复功能
 * 1.PageFactory页面元素初始化  2.页面截图（非等待）
 */
public class BasePage {
    //暂停 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='找到算我输']")
    @CacheLookup
    static WebElement stop2;

    /**
     * 初始化页面元素
     */
    public BasePage(){
        //System.out.println("-------------初始化页面");
        PageFactory.initElements(Driver.getDriverWX(),this);
    }

    /**
     * 等待页面加载
     * @param TIMEOUT
     */
    public void waitLoading(int TIMEOUT){
        PageAction.waitElement(TIMEOUT,stop2,"wx");
    }
}

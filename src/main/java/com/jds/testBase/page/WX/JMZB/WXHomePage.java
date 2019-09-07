package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 微信首页
 */
public class WXHomePage extends BasePage{
    //微信下拉小程序入口:解码直播 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='解码直播']")
    @CacheLookup
    private WebElement JMZBEnter;

    //微信底部导航:微信 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='通讯录']")
    @CacheLookup
    private WebElement BookTab;

    //暂停 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='找到算我输']")
    @CacheLookup
    private WebElement stop1;

    /**
     * 等待页面加载成功后进入解码直播小程序
     * @return
     */
    public JMHomePage openJMZB(){
        PageAction.waitElement(20,BookTab);   //等待元素出现
        PageAction.slide(50,35,50,90);   //根据设备分辨率下拉屏幕
        PageAction.waitElement(5,stop1);
        PageAction.waitElement(20,JMZBEnter);
        JMZBEnter.click();
        return new JMHomePage();
    }
}
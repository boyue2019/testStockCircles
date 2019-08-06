package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.driver.Driver;
import com.jds.testBase.util.Android.PageAction;
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
    @FindBy(xpath = "//*[@text='找不到']")
    @CacheLookup
    private WebElement stop1;

    /**
     * 等待页面加载成功后进入解码直播小程序
     * @return
     */
    public JMHomePage openJMZB(){
        PageAction.waitElement(20,BookTab,"wx");   //等待元素出现
        PageAction.slide(20,500,733,500,1800);   //下拉屏幕
        PageAction.waitElement(5,stop1,"wx");
        PageAction.waitElement(20,JMZBEnter,"wx");
        JMZBEnter.click();
        return new JMHomePage();
    }
}
package com.jds.testBase.page.WX.JMZB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class JMBottomNavigationPage extends BasePage{
    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='首页']")
    @CacheLookup
    static WebElement home;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='微课']")
    @CacheLookup
    static WebElement WeiKe;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//*[@text='我的']")
    @CacheLookup
    static WebElement mine;  //底导"首页"
}

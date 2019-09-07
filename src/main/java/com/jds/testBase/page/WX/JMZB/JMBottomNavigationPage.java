package com.jds.testBase.page.WX.JMZB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 底导元素
 */
public class JMBottomNavigationPage extends BasePage{
    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[1]")
    @CacheLookup
    static WebElement home;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[2]")
    @CacheLookup
    static WebElement WeiKe;  //底导"首页"

    //底部导航栏:首页 【NATIVE_APP】
    @FindBy(xpath = "//android.widget.LinearLayout/android.widget.RelativeLayout[3]")
    @CacheLookup
    static WebElement mine;  //底导"首页"
}

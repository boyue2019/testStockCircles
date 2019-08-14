package com.jds.testBase.page.WX.JMZB;

import com.jds.testBase.util.PageAction;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 解码直播首页
 */
public class JMHomePage extends WXHomePage implements IJMBottomNavigation{
    //启动页 【WebView】
    @FindBy(xpath = "/html/body/wx-comdialog/wx-view/wx-image/div")
    @CacheLookup
    private WebElement startPage;

    //每日干货查看全部  【WebView】
    @FindBy(xpath = "//wx-view[@class='masteritemstrategy'][1]/wx-form/span/wx-button")
    @CacheLookup
    private WebElement drycargoCheckall;

    /**
     * 关闭首次登录的启动页、引导页
     * context:WEBVIEW_com.tencent.mm:appbrand0
     */
    public void closeFirstPage(){
        PageAction.switchToWebview();
        PageAction.jumpToWindowHandel(startPage);  //遍历WindowHandel查找启动页元素
        try{
            startPage.click();   //如果找到点击关闭按钮
        }catch (NoSuchElementException e){
            System.out.println("未显示启动页.");
        }
    }

    /**
     * 跳转至每日干货查看全部
     * context:WEBVIEW_com.tencent.mm:appbrand0
     * @return
     */
    public JMDrycargoPage gotoJMDrycargoCheckAll(){
        this.waitBottomElement();
        PageAction.switchToWebview();
        PageAction.jumpToWindowHandel(drycargoCheckall);  //遍历WindowHandel查找'每日干后-查看全部'
        PageAction.click(1,drycargoCheckall,"wx");
        return new JMDrycargoPage();
    }
}